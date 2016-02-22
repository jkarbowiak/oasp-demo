package org.zosia.oasp.to;


import org.zosia.oasp.type.BookCover;
import org.zosia.oasp.type.PaperSize;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTo {
    private long id;
    private String setNumber;
    private boolean wanted;
    private boolean owned;
    private long version;
    private Set<SetPiecesTo> setPieces = new HashSet<>();

    public boolean isWanted() {
        return wanted;
    }

    public void setWanted(boolean wanted) {
        this.wanted = wanted;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(String setNumber) {
        this.setNumber = setNumber;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Set<SetPiecesTo> getSetPieces() {
        return setPieces;
    }

    public void setSetPieces(Set<SetPiecesTo> setPieces) {
        this.setPieces = setPieces;
    }

}
