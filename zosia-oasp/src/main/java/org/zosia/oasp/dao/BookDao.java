package org.zosia.oasp.dao;


import org.zosia.oasp.entity.BookEntity;
import org.zosia.oasp.to.BookSearchCriteriaTo;

import java.util.List;

public interface BookDao extends Dao<BookEntity, Long> {

    List<BookEntity> findBooks(BookSearchCriteriaTo bookSearchCriteria);
}
