package org.zosia.oasp.mapper;

import org.zosia.oasp.entity.AuthorEntity;
import org.zosia.oasp.to.AuthorTo;
import org.zosia.oasp.type.PersonalData;

public class AuthorMapper extends AbstractMapper<AuthorEntity, AuthorTo> {

    @Override
    public AuthorTo mapSource(AuthorEntity source) {
        AuthorTo target = new AuthorTo();
        target.setId(source.getId());
        target.setNickName(source.getNickName());
        target.setPersonalData(copyPersonalData(source.getPersonalData()));
        target.setVersion(source.getVersion());
        target.setGenre(source.getLiteraryGenre());
        return target;
    }

    @Override
    public AuthorEntity mapTarget(AuthorTo target) {
        return new AuthorEntity(target.getId(), copyPersonalData(target.getPersonalData()), target.getNickName(), target.getGenre(),
                target.getVersion());
    }

    private PersonalData copyPersonalData(PersonalData personalDataToCopy) {
        PersonalData personalData = null;
        if (personalDataToCopy != null) {
            personalData = new PersonalData(personalDataToCopy.getFirstName(), personalDataToCopy.getLastName(), personalDataToCopy.getBirthDate());
        }
        return personalData;
    }


}
