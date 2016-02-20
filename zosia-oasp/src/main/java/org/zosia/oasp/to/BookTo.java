package org.zosia.oasp.to;


import org.zosia.oasp.type.BookCover;
import org.zosia.oasp.type.PaperSize;

import java.util.ArrayList;
import java.util.List;

public class BookTo {
    private long id;
    private String title;
    private long version;
    private int pagesCount;
    private PaperSize paperSize;
    private BookCover bookCover;

    private List<AuthorTo> authors = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<AuthorTo> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorTo> authors) {
        this.authors = authors;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public PaperSize getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(PaperSize paperSize) {
        this.paperSize = paperSize;
    }

    public BookCover getBookCover() {
        return bookCover;
    }

    public void setBookCover(BookCover bookCover) {
        this.bookCover = bookCover;
    }
}
