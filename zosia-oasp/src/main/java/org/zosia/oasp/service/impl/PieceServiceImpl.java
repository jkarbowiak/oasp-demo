package org.zosia.oasp.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zosia.oasp.entity.PieceEntity;
import org.zosia.oasp.mapper.PieceMapper;
import org.zosia.oasp.mapper.SetMapper;
import org.zosia.oasp.repository.PieceRepository;
import org.zosia.oasp.repository.SetRepository;
import org.zosia.oasp.service.PieceService;
import org.zosia.oasp.service.SetService;
import org.zosia.oasp.to.PieceTo;
import org.zosia.oasp.to.SetTo;

import java.util.Collection;

@Service
@Transactional(readOnly = true)
public class PieceServiceImpl implements PieceService {

    private final PieceMapper pieceMapper;
    private final PieceRepository pieceRepository;

    @Autowired
    public PieceServiceImpl(PieceMapper pieceMapper, PieceRepository pieceRepository) {
        this.pieceMapper = pieceMapper;
        this.pieceRepository = pieceRepository;
    }

    @Override
    public Collection<PieceTo> findOwnedPieces() {
        return pieceMapper.mapSourceCollectionRoot(Lists.newArrayList(pieceRepository.findAll()));
    }
}
