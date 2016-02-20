package org.zosia.oasp.entity;

import org.zosia.oasp.type.BookCover;
import org.zosia.oasp.type.PaperSize;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BOOK_EXEMPLAR")
public class BookExemplarEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false, length = 15, unique = true)
    protected String serialNumber;

    @ManyToOne
    @JoinColumn(name = "BOOK_FK", nullable = false)
    private BookEntity book;

    private int pagesCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaperSize paperSize;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookCover bookCover;

    // for hibernate
    protected BookExemplarEntity() {
    }

    public BookExemplarEntity(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BookExemplarEntity(Long id, String serialNumber) {
        this(serialNumber);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }


    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
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
