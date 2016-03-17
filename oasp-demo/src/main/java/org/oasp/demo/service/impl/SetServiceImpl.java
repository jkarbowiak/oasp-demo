package org.oasp.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.oasp.demo.entity.SetEntity;
import org.oasp.demo.mapper.SetMapper;
import org.oasp.demo.repository.SetRepository;
import org.oasp.demo.service.SetService;
import org.oasp.demo.to.SetTo;
import org.oasp.demo.to.WantedSetTo;

import java.util.Collection;

@Service
public class SetServiceImpl implements SetService {

    private final SetMapper setMapper;
    private final SetRepository setRepository;

    @Autowired
    public SetServiceImpl(SetMapper setMapper, SetRepository bookRepository) {
        this.setMapper = setMapper;
        this.setRepository = bookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<SetTo> findOwnedSets() {
        return setMapper.mapSourceCollectionRoot(setRepository.findOwnedSets());
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<SetTo> findWantedSets() {
        return setMapper.mapSourceCollectionRoot(setRepository.findWantedSets());
    }

    @Override
    @Transactional(readOnly = false)
    public void addWantedSet(WantedSetTo setTo) {
        SetEntity setEntity = setMapper.mapTarget(new SetTo(setTo));

        setRepository.save(setEntity);
    }
}
