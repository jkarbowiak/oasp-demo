package org.zosia.oasp.dao.impl;

import org.springframework.stereotype.Repository;
import org.zosia.oasp.dao.BookExemplarDao;
import org.zosia.oasp.entity.BookExemplarEntity;

import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class BookExemplarDaoImpl extends AbstractDao<BookExemplarEntity, Long> implements BookExemplarDao {

    @Override
    public boolean isBookExemplarBorrowed(long bookExemplarId) {
        TypedQuery<Long> query = entityManager.createQuery(
                "select count(l.id) from LoanEntity l " +
                        "join l.bookExemplars exemplars " +
                        "where exemplars.id = :bookExemplarId", Long.class);

        query.setParameter("bookExemplarId", bookExemplarId);
        return query.getSingleResult() > 0;
    }

    @Override
    public Collection<BookExemplarEntity> findAllBookExemplars(long bookId) {
        return entityManager.createQuery(
                "select exemplar from BookExemplarEntity exemplar where exemplar.book.id = :bookId", BookExemplarEntity.class
        ).setParameter("bookId", bookId).getResultList();
    }

}
