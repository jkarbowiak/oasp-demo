package org.zosia.oasp.repository;

import org.zosia.oasp.entity.BookEntity;
import org.zosia.oasp.to.BookSearchCriteriaTo;

import java.util.List;

public interface BookRepositoryCustom {

    List<BookEntity> findBooks(BookSearchCriteriaTo bookSearchCriteria);
}
