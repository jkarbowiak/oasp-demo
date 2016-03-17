package org.oasp.demo.to;

import java.util.HashSet;
import java.util.Set;

public class PieceTo {

    private long id;
    private String pieceNumber;
    private String color;
    private Integer weight;
    private Integer pieceCount;
    private long version;
    private Set<SetPiecesTo> setPieces = new HashSet<>();

    public long getId() {
        return id;
    }

    public Integer getPieceCount() {
        return pieceCount;
    }

    public void setPieceCount(Integer pieceCount) {
        this.pieceCount = pieceCount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPieceNumber() {
        return pieceNumber;
    }

    public void setPieceNumber(String pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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
