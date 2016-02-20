package org.zosia.oasp.entity;

import org.zosia.oasp.type.LiteraryGenre;
import org.zosia.oasp.type.PersonalData;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AUTHOR")
public class AuthorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true, length = 30)
    private String nickName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "FIRST_NAME", nullable = false)),
            @AttributeOverride(name = "lastName", column = @Column(name = "LAST_NAME", nullable = false))})
    private PersonalData personalData;

    @Enumerated(EnumType.STRING)
    private LiteraryGenre literaryGenre;

    @Version
    private long version;

    // for hibernate
    protected AuthorEntity() {

    }

    public AuthorEntity(PersonalData personalData, String nickName) {
        this.personalData = personalData;
        this.nickName = nickName;
    }

    public AuthorEntity(Long id, PersonalData personalData, String nickName, LiteraryGenre literaryGenre, long version) {
        this(personalData, nickName);
        this.literaryGenre = literaryGenre;
        this.id = id;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public String getNickName() {
        return nickName;
    }

    public LiteraryGenre getLiteraryGenre() {
        return literaryGenre;
    }

    public void setLiteraryGenre(LiteraryGenre literaryGenre) {
        this.literaryGenre = literaryGenre;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
