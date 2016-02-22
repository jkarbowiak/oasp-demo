package org.zosia.oasp.repository.impl;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.HQLTemplates;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.util.StringUtils;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookRepositoryImpl /*implements BookRepositoryCustom*/ {

    /*@PersistenceContext
    private EntityManager entityManager;

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
            query.where(predicate);
        }

        return query.listResults(bookEntity).getResults();
    }*/
}
