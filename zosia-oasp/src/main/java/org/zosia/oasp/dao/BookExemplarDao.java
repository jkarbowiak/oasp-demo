package org.zosia.oasp.dao;


import org.zosia.oasp.entity.BookExemplarEntity;

import java.util.Collection;

public interface BookExemplarDao extends Dao<BookExemplarEntity, Long> {

    boolean isBookExemplarBorrowed(long bookExemplarId);

    Collection<BookExemplarEntity> findAllBookExemplars(long bookId);

}
