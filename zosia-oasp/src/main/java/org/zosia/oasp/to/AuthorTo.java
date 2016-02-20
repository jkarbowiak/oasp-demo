package org.zosia.oasp.to;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.zosia.oasp.type.LiteraryGenre;
import org.zosia.oasp.type.PersonalData;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class AuthorTo {

    private Long id;
    private String nickName;
    private PersonalData personalData;
    private long version;
    private LiteraryGenre genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public LiteraryGenre getGenre() {
        return genre;
    }

    public void setGenre(LiteraryGenre genre) {
        this.genre = genre;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

}
