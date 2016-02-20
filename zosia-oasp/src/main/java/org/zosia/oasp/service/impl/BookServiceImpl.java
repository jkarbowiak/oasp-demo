package org.zosia.oasp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zosia.oasp.entity.BookEntity;
import org.zosia.oasp.mapper.BookExemplarMapper;
import org.zosia.oasp.mapper.BookMapper;
import org.zosia.oasp.repository.BookExemplarRepository;
import org.zosia.oasp.repository.BookRepository;
import org.zosia.oasp.service.BookService;
import org.zosia.oasp.to.BookExemplarTo;
import org.zosia.oasp.to.BookSearchCriteriaTo;
import org.zosia.oasp.to.BookTo;
import org.zosia.oasp.to.NewBookTo;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final BookExemplarRepository bookExemplarRepository;
    private final BookExemplarMapper bookExemplarMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper, BookRepository bookRepository,
                           BookExemplarRepository bookExemplarRepository, BookExemplarMapper bookExemplarMapper) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
        this.bookExemplarRepository = bookExemplarRepository;
        this.bookExemplarMapper = bookExemplarMapper;
    }

    @Override
    public BookTo findBookById(long bookId) {
        return bookMapper.mapSource(bookRepository.findOne(bookId));
    }

    @Override
    public List<BookTo> findBooks(BookSearchCriteriaTo searchCriteria) {
        List<BookEntity> books = bookRepository.findBooks(searchCriteria);
        return new ArrayList<>(bookMapper.mapSourceCollection(books));
    }

    @Override
    @Transactional(readOnly = false)
    public BookTo createBook(NewBookTo bookToSave) {
        BookEntity bookEntity = bookMapper.mapNewBook(bookToSave);
        bookEntity = bookRepository.save(bookEntity);
        return bookMapper.mapSource(bookEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public BookTo updateBook(BookTo bookTo) {
        BookEntity bookEntity = bookMapper.mapTarget(bookTo);
        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        return bookMapper.mapSource(savedBookEntity);
    }

    @Override
    public List<BookExemplarTo> findBookExemplars(long bookId) {
        return new ArrayList<>(bookExemplarMapper.mapSourceCollection(bookExemplarRepository.findAllBookExemplars(bookId)));
    }

    @Override
    @Transactional(readOnly = false)
    public void removeBookById(long bookIdToRemove) {
        bookRepository.delete(bookIdToRemove);
    }
}
