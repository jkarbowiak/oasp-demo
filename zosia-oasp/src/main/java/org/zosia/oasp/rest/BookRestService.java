package org.zosia.oasp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zosia.oasp.service.BookService;
import org.zosia.oasp.to.*;

import java.util.List;

@RestController
public class BookRestService {

    private final BookService bookService;

    @Autowired
    public BookRestService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<BookTo> findBooks(BookSearchCriteriaTo searchCriteria) {
        return bookService.findBooks(searchCriteria);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseBody
    public BookTo createBook(@RequestBody NewBookTo bookToSave) {
        return bookService.createBook(bookToSave);
    }

}
