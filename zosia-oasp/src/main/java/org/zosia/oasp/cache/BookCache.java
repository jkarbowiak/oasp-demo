package org.zosia.oasp.cache;

import org.zosia.oasp.to.BookSearchCriteriaTo;
import org.zosia.oasp.to.BookTo;

import java.util.List;

public interface BookCache {

    List<BookTo> findBooks(BookSearchCriteriaTo searchCriteria);
}
