package org.zosia.oasp.dao.impl;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.HQLTemplates;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.zosia.oasp.dao.BookDao;
import org.zosia.oasp.entity.*;
import org.zosia.oasp.to.BookSearchCriteriaTo;

import java.util.List;

@Repository
public class BookDaoImpl extends AbstractDao<BookEntity, Long> implements BookDao {

    @Override
    public List<BookEntity> findBooks(BookSearchCriteriaTo bookSearchCriteria) {
        final QBookEntity bookEntity = QBookEntity.bookEntity;
        final JPAQuery query = new JPAQuery(entityManager, HQLTemplates.DEFAULT).from(bookEntity);

        if (bookSearchCriteria != null) {
            final BooleanBuilder predicate = new BooleanBuilder();

            if (!StringUtils.isEmpty(bookSearchCriteria.getTitle())) {
                final String title = bookSearchCriteria.getTitle();
                predicate.and(bookEntity.title.startsWithIgnoreCase(title));
            }
            if (!StringUtils.isEmpty(bookSearchCriteria.getAuthor())) {
                final String author = bookSearchCriteria.getAuthor();
                predicate.and(bookEntity.authors.any().personalData.firstName.startsWithIgnoreCase(author)
                        .or(bookEntity.authors.any().personalData.lastName.startsWithIgnoreCase(author)))
                        .or(bookEntity.authors.any().nickName.startsWithIgnoreCase(author));
            }
            if (Boolean.TRUE.equals(bookSearchCriteria.getHasSpoiler())) {
                predicate.and(bookEntity.bookSpoiler.id.isNotNull());
            }
            if (Boolean.FALSE.equals(bookSearchCriteria.getHasSpoiler())) {
                QBookSpoilerEntity bookSpoilerEntity = QBookSpoilerEntity.bookSpoilerEntity;
                predicate.and(new JPASubQuery().from(bookSpoilerEntity).where(bookEntity.id.eq(bookSpoilerEntity.book.id)).notExists());
            }
            if (Boolean.TRUE.equals(bookSearchCriteria.getAvailable())) {
                predicate.and(bookEntity.bookExemplars.any().loan.isNull());
            }
            if (Boolean.FALSE.equals(bookSearchCriteria.getAvailable())) {
                QBookExemplarEntity bookExemplarEntity = QBookExemplarEntity.bookExemplarEntity;
                QLoanEntity loanEntity = QLoanEntity.loanEntity;

                predicate.and(new JPASubQuery().from(bookExemplarEntity).where(bookExemplarEntity.book.id.eq(bookEntity.id)).count().eq(
                        new JPASubQuery().from(loanEntity).where(loanEntity.bookExemplars.any().book.id.eq(bookEntity.id)).count()
                ));
            }
            query.where(predicate);
        }

        return query.listResults(bookEntity).getResults();
    }
}
