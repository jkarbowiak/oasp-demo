package org.zosia.oasp.entity;

import org.zosia.oasp.type.BookCover;
import org.zosia.oasp.type.PaperSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "LEGO_PIECE")
public class PieceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false, length = 25)
    protected String pieceNumber;

    @Column(nullable = false, length = 35)
    private String color;

    @Column(nullable = true)
    private Integer weight;

    @Column(nullable = false)
    private Integer pieceCount;

    @Version
    private long version;

    @OneToMany(mappedBy="piece")
    private Set<SetPiecesEntity> setPieces;

    // for hibernate
    protected PieceEntity() {
    }

    public PieceEntity(String pieceNumber, String color, Integer pieceCount) {
        this.pieceNumber = pieceNumber;
        this.color = color;
        this.pieceCount = pieceCount;
    }

    public String getColor() {
        return color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPieceNumber() {
        return pieceNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public Set<SetPiecesEntity> getSetPieces() {
        return setPieces;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Integer getPieceCount() {
        return pieceCount;
    }

    public void setPieceCount(Integer pieceCount) {
        this.pieceCount = pieceCount;
    }
}
