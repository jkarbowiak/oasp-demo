package org.zosia.oasp.service;


import org.zosia.oasp.to.*;

import java.util.List;

public interface BookService {

    BookTo findBookById(long bookId);

    List<BookTo> findBooks(BookSearchCriteriaTo searchCriteria);

    BookLoanResultTo loanBook(BookLoanRequestTo bookLoanRequest);

    BookTo createBook(NewBookTo bookToSave);

    BookTo updateBook(BookTo bookTo);

    String findBookSpoiler(long bookId);

    List<BookExemplarTo> findBookExemplars(long bookId);

    void removeBookById(long bookIdToRemove);
}
