package org.zosia.oasp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LEGO_SET")
public class SetEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String setNumber;

    @Column
    private long wanted;

    @Column
    private long owned;

    @OneToMany(mappedBy="set")
    private Set<SetPiecesEntity> setPieces;

    @Version
    private long version;

    // for hibernate
    protected SetEntity() {
    }

    public SetEntity(Long id, String setNumber, long wanted, long owned) {
        this.id = id;
        this.setNumber = setNumber;
        this.wanted = wanted;
        this.owned = owned;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public long getWanted() {
        return wanted;
    }

    public long getOwned() {
        return owned;
    }

    public String getSetNumber() {
        return setNumber;
    }

    public Set<SetPiecesEntity> getSetPieces() {
        return setPieces;
    }

    public void setSetPieces(Set<SetPiecesEntity> setPieces) {
        this.setPieces = setPieces;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

}
