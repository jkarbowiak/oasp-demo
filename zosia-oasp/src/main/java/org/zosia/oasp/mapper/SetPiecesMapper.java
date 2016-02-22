package org.zosia.oasp.mapper;

import org.zosia.oasp.entity.SetPiecesEntity;
import org.zosia.oasp.to.SetPiecesTo;

public class SetPiecesMapper extends AbstractMapper<SetPiecesEntity, SetPiecesTo> {

    @Override
    public SetPiecesTo mapSource(SetPiecesEntity source) {
        SetPiecesTo target = mapSourceRoot(source);
        if (source != null) {
            target.setPiece(new PieceMapper().mapSource(source.getPiece()));
        }
        return target;
    }

    @Override
    public SetPiecesTo mapSourceRoot(SetPiecesEntity source) {
        SetPiecesTo target = new SetPiecesTo();
        if (source != null) {
            target.setId(source.getId());
            target.setPieceCount(source.getPieceCount());
            target.setVersion(source.getVersion());
            target.setSetId(source.getSet().getId());
        }
        return target;
    }

    @Override
    public SetPiecesEntity mapTarget(SetPiecesTo target) {
        return new SetPiecesEntity(target.getId(), target.getPieceCount(), target.getVersion());
    }

}
