package org.zosia.oasp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zosia.oasp.entity.SetEntity;
import org.zosia.oasp.mapper.SetMapper;
import org.zosia.oasp.repository.SetRepository;
import org.zosia.oasp.service.SetService;
import org.zosia.oasp.to.PieceTo;
import org.zosia.oasp.to.SetTo;
import org.zosia.oasp.to.WantedSetTo;

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
