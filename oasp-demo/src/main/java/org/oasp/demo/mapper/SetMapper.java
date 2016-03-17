package org.oasp.demo.mapper;

import org.springframework.stereotype.Component;
import org.oasp.demo.entity.SetEntity;
import org.oasp.demo.to.SetTo;

import java.util.HashSet;

@Component
public class SetMapper extends AbstractMapper<SetEntity, SetTo> {
    

    @Override
    public SetTo mapSource(SetEntity source) {
        SetTo setTo = mapSourceRoot(source);
        if (source != null) {
            setTo.setSetPieces(new HashSet<>(new SetPiecesMapper().mapSourceCollection(source.getSetPieces())));
        }
        return setTo;
    }

    @Override
    public SetTo mapSourceRoot(SetEntity source) {
        SetTo set = null;
        if (source != null) {
            set = new SetTo();
            set.setId(source.getId());
            set.setSetNumber(source.getSetNumber());
            set.setWanted(source.getWanted() == 1);
            set.setOwned(source.getOwned() == 1);
            set.setVersion(source.getVersion());
        }
        return set;
    }

    @Override
    public SetEntity mapTarget(SetTo target) {
        SetEntity set = null;
        if (target != null) {
            set = new SetEntity(target.getId(), target.getSetNumber(), target.isWanted() ? 1:0, target.isOwned() ? 1:0);
            set.setSetPieces(new HashSet<>(new SetPiecesMapper().mapTargetCollection(target.getSetPieces())));
            set.setVersion(target.getVersion());
        }
        return set;
    }
}
