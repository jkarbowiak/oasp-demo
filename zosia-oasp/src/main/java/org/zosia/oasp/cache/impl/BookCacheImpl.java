package org.zosia.oasp.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zosia.oasp.cache.BookCache;
import org.zosia.oasp.service.BookService;
import org.zosia.oasp.to.BookSearchCriteriaTo;
import org.zosia.oasp.to.BookTo;

import java.util.List;

@Service
public class BookCacheImpl implements BookCache {

    private final BookService bookService;

    @Autowired
    public BookCacheImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Cacheable(value = "books", keyGenerator = "cacheKeyProvider")
    @Override
    public List<BookTo> findBooks(BookSearchCriteriaTo searchCriteria) {
        return bookService.findBooks(searchCriteria);
    }
}
