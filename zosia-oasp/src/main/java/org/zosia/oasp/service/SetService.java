package org.zosia.oasp.service;


import org.zosia.oasp.to.*;

import java.util.Collection;
import java.util.List;

public interface SetService {

    Collection<SetTo> findOwnedSets();

    Collection<SetTo> findWantedSets();

    void addWantedSet(WantedSetTo setTo);

    /*List<BookTo> findBooks(BookSearchCriteriaTo searchCriteria);

    BookTo createBook(NewBookTo bookToSave);

    BookTo updateBook(BookTo bookTo);

    List<BookExemplarTo> findBookExemplars(long bookId);

    void removeBookById(long bookIdToRemove);*/
}
