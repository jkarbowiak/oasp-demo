package org.zosia.oasp.mapper;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.zosia.oasp.entity.AudioBookExemplarEntity;
import org.zosia.oasp.entity.BookExemplarEntity;
import org.zosia.oasp.entity.PaperBookExemplarEntity;
import org.zosia.oasp.to.AudioBookExemplarTo;
import org.zosia.oasp.to.BookExemplarTo;
import org.zosia.oasp.to.PaperBookExemplarTo;

@Component
public class BookExemplarMapper extends AbstractMapper<BookExemplarEntity, BookExemplarTo> {

    @Override
    public BookExemplarTo mapSource(BookExemplarEntity source) {

        if (isObjectOfClass(source, AudioBookExemplarEntity.class)) {
            return mapAudioBookExemplar((AudioBookExemplarEntity) HibernateProxyHelper.unwrap(source));
        }
        else if (isObjectOfClass(source, PaperBookExemplarEntity.class)) {
            return mapPaperBookExemplar((PaperBookExemplarEntity) HibernateProxyHelper.unwrap(source));
        }
        else {
            throw new IllegalArgumentException("Not supported mapping for class " + source.getClass().getName());
        }
    }

    private AudioBookExemplarTo mapAudioBookExemplar(AudioBookExemplarEntity source) {
        return new AudioBookExemplarTo(source.getId(), source.getSerialNumber(), source.getFormat());
    }

    private PaperBookExemplarTo mapPaperBookExemplar(PaperBookExemplarEntity source) {
        return new PaperBookExemplarTo(source.getId(), source.getSerialNumber(), source.getPagesCount(), source.getPaperSize(), source.getBookCover());
    }

    private boolean isObjectOfClass(Object object, Class<?> clazz) {
        return object != null && Hibernate.getClass(object) == clazz;
    }

    @Override
    public BookExemplarEntity mapTarget(BookExemplarTo target) {
        throw new UnsupportedOperationException("Conversion from BookExemplarTo to BookExemplarEntity is not implemented yet.");
    }
}
