package org.zosia.oasp.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.zosia.oasp.dao.AuthorDao;
import org.zosia.oasp.entity.*;
import org.zosia.oasp.to.*;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class BookMapper extends AbstractMapper<BookEntity, BookTo> {

    private final AuthorDao authorDao;

    @Autowired
    public BookMapper(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public BookTo mapSource(BookEntity source) {
        BookTo book = null;
        if (source != null) {
            book = new BookTo();
            book.setId(source.getId());
            book.setTitle(source.getTitle());
            book.setAuthors(new ArrayList<>(new AuthorMapper().mapSourceCollection(source.getAuthors())));
            book.setVersion(source.getVersion());
        }
        return book;
    }

    @Override
    public BookEntity mapTarget(BookTo target) {
        BookEntity book = null;
        if (target != null) {
            book = new BookEntity(target.getId(), target.getTitle());
            book.setAuthors(new HashSet<>(new AuthorMapper().mapTargetCollection(target.getAuthors())));
            book.setVersion(target.getVersion());
        }
        return book;
    }

    public BookEntity mapNewBook(NewBookTo newBook) {
        if (newBook == null) {
            return null;
        }

        BookEntity book = new BookEntity(newBook.getTitle());

        Set<AuthorEntity> bookAuthors = mapAuthors(newBook.getAuthors());
        book.setAuthors(bookAuthors);

        Set<BookExemplarEntity> bookExemplars = mapBookExemplars(newBook.getExemplars());
        bookExemplars.stream().forEach(book::addBookExemplar);

        return book;
    }

    private Set<AuthorEntity> mapAuthors(Collection<Long> authorIds) {
        if (!authorIds.isEmpty()) {
            return authorIds.stream().map(this::findAuthorReference).collect(Collectors.toSet());
        }
        return new HashSet<>();
    }

    private AuthorEntity findAuthorReference(long authorId) {
        return authorDao.getOne(authorId);
    }

    private Set<BookExemplarEntity> mapBookExemplars(Set<? extends BookExemplarTo> exemplars) {
        if (!exemplars.isEmpty()) {
            return exemplars.stream().map(this::mapBookExemplar).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

    private BookExemplarEntity mapBookExemplar(BookExemplarTo bookExemplarTo) {
        BookExemplarEntity bookExemplarEntity = new BookExemplarEntity(bookExemplarTo.getId(), bookExemplarTo.getSerialNumber());
        bookExemplarEntity.setPaperSize(bookExemplarTo.getPaperSize());
        bookExemplarEntity.setPagesCount(bookExemplarTo.getPagesCount());
        return bookExemplarEntity;
    }
}
