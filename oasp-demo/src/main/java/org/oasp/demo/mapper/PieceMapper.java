package org.oasp.demo.mapper;

import org.springframework.stereotype.Component;
import org.oasp.demo.entity.PieceEntity;
import org.oasp.demo.to.PieceTo;

@Component
public class PieceMapper extends AbstractMapper<PieceEntity, PieceTo> {

    @Override
    public PieceTo mapSource(PieceEntity source) {
        return mapSourceRoot(source);
    }

    @Override
    public PieceTo mapSourceRoot(PieceEntity source) {
        PieceTo pieceTo = new PieceTo();
        pieceTo.setId(source.getId());
        pieceTo.setVersion(source.getVersion());
        pieceTo.setColor(source.getColor());
        pieceTo.setPieceNumber(source.getPieceNumber());
        pieceTo.setPieceCount(source.getPieceCount());
        pieceTo.setWeight(source.getWeight());
        return pieceTo;
    }

    @Override
    public PieceEntity mapTarget(PieceTo target) {
        throw new UnsupportedOperationException("Conversion from BookExemplarTo to BookExemplarEntity is not implemented yet.");
    }
}
