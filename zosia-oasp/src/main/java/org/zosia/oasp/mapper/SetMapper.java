package org.zosia.oasp.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zosia.oasp.entity.SetEntity;
import org.zosia.oasp.to.SetTo;

import java.util.HashSet;

@Component
public class SetMapper extends AbstractMapper<SetEntity, SetTo> {

//    private final SetRepository setDao;
//
//    @Autowired
//    public SetMapper(SetRepository setDao) {
//        this.setDao = setDao;
//    }

    @Override
    public SetTo mapSource(SetEntity source) {
        SetTo setTo = mapSourceRoot(source);
        if (source != null) {
            setTo.setSetPieces(new HashSet<>(new SetPiecesMapper().mapSourceCollection(source.getSetPieces())));
        }
        return setTo;
    }

    @Override
    public SetTo mapSourceRoot(SetEntity source) {
        SetTo set = null;
        if (source != null) {
            set = new SetTo();
            set.setId(source.getId());
            set.setSetNumber(source.getSetNumber());
            set.setWanted(source.getWanted() == 1);
            set.setOwned(source.getOwned() == 1);
            set.setVersion(source.getVersion());
        }
        return set;
    }

    @Override
    public SetEntity mapTarget(SetTo target) {
        SetEntity set = null;
        if (target != null) {
            set = new SetEntity(target.getId(), target.getSetNumber(), target.isWanted() ? 1:0, target.isOwned() ? 1:0);
            set.setSetPieces(new HashSet<>(new SetPiecesMapper().mapTargetCollection(target.getSetPieces())));
            set.setVersion(target.getVersion());
        }
        return set;
    }

//    public SetEntity mapNewBook(NewBookTo newBook) {
//        if (newBook == null) {
//            return null;
//        }
//
//        SetEntity book = new SetEntity(newBook.getTitle());
//
//        Set<AuthorEntity> bookAuthors = mapAuthors(newBook.getAuthors());
//        book.setAuthors(bookAuthors);
//
//        Set<BookExemplarEntity> bookExemplars = mapBookExemplars(newBook.getExemplars());
//        bookExemplars.stream().forEach(book::addBookExemplar);
//
//        return book;
//    }
//
//    private Set<AuthorEntity> mapAuthors(Collection<Long> authorIds) {
//        if (!authorIds.isEmpty()) {
//            return authorIds.stream().map(this::findAuthorReference).collect(Collectors.toSet());
//        }
//        return new HashSet<>();
//    }
//
//    private AuthorEntity findAuthorReference(long authorId) {
//        return authorDao.findOne(authorId);
//    }
//
//    private Set<BookExemplarEntity> mapBookExemplars(Set<? extends BookExemplarTo> exemplars) {
//        if (!exemplars.isEmpty()) {
//            return exemplars.stream().map(this::mapBookExemplar).collect(Collectors.toSet());
//        }
//        return Collections.emptySet();
//    }
//
//    private BookExemplarEntity mapBookExemplar(BookExemplarTo bookExemplarTo) {
//        BookExemplarEntity bookExemplarEntity = new BookExemplarEntity(bookExemplarTo.getId(), bookExemplarTo.getSerialNumber());
//        bookExemplarEntity.setPaperSize(bookExemplarTo.getPaperSize());
//        bookExemplarEntity.setPagesCount(bookExemplarTo.getPagesCount());
//        return bookExemplarEntity;
//    }
}
