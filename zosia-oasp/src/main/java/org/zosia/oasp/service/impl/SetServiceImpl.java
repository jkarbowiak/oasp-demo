package org.zosia.oasp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zosia.oasp.mapper.SetMapper;
import org.zosia.oasp.repository.SetRepository;
import org.zosia.oasp.service.SetService;
import org.zosia.oasp.to.PieceTo;
import org.zosia.oasp.to.SetTo;

import java.util.Collection;

@Service
@Transactional(readOnly = true)
public class SetServiceImpl implements SetService {

    private final SetMapper bookMapper;
    private final SetRepository bookRepository;

    @Autowired
    public SetServiceImpl(SetMapper setMapper, SetRepository bookRepository) {
        this.bookMapper = setMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public Collection<SetTo> findOwnedSets() {
        return bookMapper.mapSourceCollectionRoot(bookRepository.findOwnedSets());
    }

    @Override
    public Collection<SetTo> findWantedSets() {
        return bookMapper.mapSourceCollectionRoot(bookRepository.findWantedSets());
    }

    /*@Override
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
    }*/
}
