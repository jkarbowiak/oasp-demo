package org.zosia.oasp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zosia.oasp.dao.BookDao;
import org.zosia.oasp.dao.BookExemplarDao;
import org.zosia.oasp.entity.*;
import org.zosia.oasp.mapper.BookExemplarMapper;
import org.zosia.oasp.mapper.BookMapper;
import org.zosia.oasp.service.BookService;
import org.zosia.oasp.service.helper.CurrentDateProvider;
import org.zosia.oasp.to.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final CurrentDateProvider currentDateProvider;
    private final BookDao bookDao;
    private final BookExemplarDao bookExemplarDao;
    private final BookExemplarMapper bookExemplarMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper, CurrentDateProvider currentDateProvider, BookDao bookDao,
                           BookExemplarDao bookExemplarDao, BookExemplarMapper bookExemplarMapper) {
        this.bookMapper = bookMapper;
        this.currentDateProvider = currentDateProvider;
        this.bookDao = bookDao;
        this.bookExemplarDao = bookExemplarDao;
        this.bookExemplarMapper = bookExemplarMapper;
    }

    @Override
    public BookTo findBookById(long bookId) {
        return bookMapper.mapSource(bookDao.find(bookId));
    }

    @Override
    public List<BookTo> findBooks(BookSearchCriteriaTo searchCriteria) {
        List<BookEntity> books = bookDao.findBooks(searchCriteria);
        return new ArrayList<>(bookMapper.mapSourceCollection(books));
    }



    @Override
    @Transactional(readOnly = false)
    public BookTo createBook(NewBookTo bookToSave) {
        BookEntity bookEntity = bookMapper.mapNewBook(bookToSave);
        bookEntity = bookDao.save(bookEntity);
        return bookMapper.mapSource(bookEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public BookTo updateBook(BookTo bookTo) {
        BookEntity bookEntity = bookMapper.mapTarget(bookTo);
        BookEntity savedBookEntity = bookDao.update(bookEntity);
        bookDao.flush();
        return bookMapper.mapSource(savedBookEntity);
    }

    @Override
    public List<BookExemplarTo> findBookExemplars(long bookId) {
        return new ArrayList<>(bookExemplarMapper.mapSourceCollection(bookExemplarDao.findAllBookExemplars(bookId)));
    }

    @Override
    @Transactional(readOnly = false)
    public void removeBookById(long bookIdToRemove) {
        bookDao.delete(bookIdToRemove);
    }
}
