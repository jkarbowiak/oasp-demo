package org.oasp.demo.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.oasp.demo.mapper.PieceMapper;
import org.oasp.demo.repository.PieceRepository;
import org.oasp.demo.service.PieceService;
import org.oasp.demo.to.PieceTo;

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
