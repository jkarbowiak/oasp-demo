package org.oasp.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LEGO_SET_PIECES")
public class SetPiecesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int pieceCount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SET_ID")
    private SetEntity set;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PIECE_ID")
    private PieceEntity piece;

    @Version
    private long version;

    // for hibernate
    protected SetPiecesEntity() {
    }

    public SetPiecesEntity(long id, int pieceCount, long version) {
        this.id = id;
        this.pieceCount = pieceCount;
        this.version = version;
    }

    public int getPieceCount() {
        return pieceCount;
    }

    public void setPieceCount(int pieceCount) {
        this.pieceCount = pieceCount;
    }

    public Long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public SetEntity getSet() {
        return set;
    }

    public void setSet(SetEntity set) {
        this.set = set;
    }

    public PieceEntity getPiece() {
        return piece;
    }

    public void setPiece(PieceEntity piece) {
        this.piece = piece;
    }
}
