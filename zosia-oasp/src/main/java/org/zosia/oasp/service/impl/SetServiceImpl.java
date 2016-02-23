package org.zosia.oasp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zosia.oasp.entity.SetEntity;
import org.zosia.oasp.mapper.SetMapper;
import org.zosia.oasp.repository.SetRepository;
import org.zosia.oasp.service.SetService;
import org.zosia.oasp.to.PieceTo;
import org.zosia.oasp.to.SetTo;
import org.zosia.oasp.to.WantedSetTo;

import java.util.Collection;

@Service
public class SetServiceImpl implements SetService {

    private final SetMapper setMapper;
    private final SetRepository setRepository;

    @Autowired
    public SetServiceImpl(SetMapper setMapper, SetRepository bookRepository) {
        this.setMapper = setMapper;
        this.setRepository = bookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<SetTo> findOwnedSets() {
        return setMapper.mapSourceCollectionRoot(setRepository.findOwnedSets());
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<SetTo> findWantedSets() {
        return setMapper.mapSourceCollectionRoot(setRepository.findWantedSets());
    }

    @Override
    @Transactional(readOnly = false)
    public void addWantedSet(WantedSetTo setTo) {
        SetEntity setEntity = setMapper.mapTarget(new SetTo(setTo));

        setRepository.save(setEntity);
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
