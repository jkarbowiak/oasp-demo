package org.zosia.oasp.mapper;

import org.hibernate.Hibernate;
import org.zosia.oasp.entity.AuthorEntity;
import org.zosia.oasp.entity.WriterEntity;
import org.zosia.oasp.to.AuthorTo;
import org.zosia.oasp.to.WriterTo;
import org.zosia.oasp.type.PersonalData;

public class AuthorMapper extends AbstractMapper<AuthorEntity, AuthorTo> {

    @Override
    public AuthorTo mapSource(AuthorEntity source) {
        if (isWriter(source)) {
            return mapWriter((WriterEntity) HibernateProxyHelper.unwrap(source));
        }

        return null;
    }

    @Override
    public AuthorEntity mapTarget(AuthorTo target) {
        if (isWriter(target)) {
            return mapWriter((WriterTo) target);
        }
        return null;
    }

    private WriterTo mapWriter(WriterEntity source) {
        WriterTo writer = new WriterTo();
        mapSource(source, writer);
        writer.setGenre(source.getLiteraryGenre());
        return writer;
    }

    private WriterEntity mapWriter(WriterTo target) {
        return new WriterEntity(target.getId(), copyPersonalData(target.getPersonalData()), target.getGenre(), target.getNickName(),
                target.getVersion());
    }

    protected void mapSource(AuthorEntity source, AuthorTo target) {
        target.setId(source.getId());
        target.setNickName(source.getNickName());
        target.setPersonalData(copyPersonalData(source.getPersonalData()));
        target.setVersion(source.getVersion());
    }

    private PersonalData copyPersonalData(PersonalData personalDataToCopy) {
        PersonalData personalData = null;
        if (personalDataToCopy != null) {
            personalData = new PersonalData(personalDataToCopy.getFirstName(), personalDataToCopy.getLastName(), personalDataToCopy.getBirthDate());
        }
        return personalData;
    }

    private boolean isWriter(AuthorEntity entity) {
        return entity != null && Hibernate.getClass(entity) == WriterEntity.class;
    }

    private boolean isWriter(AuthorTo to) {
        return to != null && to instanceof WriterTo;
    }


}
