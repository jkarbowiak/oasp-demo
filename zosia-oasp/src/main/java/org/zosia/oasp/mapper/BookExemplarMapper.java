package org.zosia.oasp.mapper;

import org.springframework.stereotype.Component;
import org.zosia.oasp.entity.BookExemplarEntity;
import org.zosia.oasp.to.BookExemplarTo;

@Component
public class BookExemplarMapper extends AbstractMapper<BookExemplarEntity, BookExemplarTo> {

    @Override
    public BookExemplarTo mapSource(BookExemplarEntity source) {
        BookExemplarTo bookExemplarTo = new BookExemplarTo();
        bookExemplarTo.setBookCover(source.getBookCover());
        bookExemplarTo.setId(source.getId());
        bookExemplarTo.setPagesCount(source.getPagesCount());
        bookExemplarTo.setSerialNumber(source.getSerialNumber());
        bookExemplarTo.setPaperSize(source.getPaperSize());
        return bookExemplarTo;
    }

    @Override
    public BookExemplarEntity mapTarget(BookExemplarTo target) {
        throw new UnsupportedOperationException("Conversion from BookExemplarTo to BookExemplarEntity is not implemented yet.");
    }
}
