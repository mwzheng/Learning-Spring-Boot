package com.example.Learning.Spring.Boot.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Used to show that it's used for api calls
@RequestMapping(path = "api/v1/book")
public class BookController {
    private final BookService bookService;

    @Autowired // Auto instantiate (new) bookService & inject it into the constructor
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // HTTP GET Request
    // ROUTE: http://localhost:8080/api/v1/book
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    // HTTP POST Request
    // ROUTE: http://localhost:8080/api/v1/book
    @PostMapping
    public void addNewBook(@RequestBody Book newBook) { // Get data from req body
        bookService.addNewBook(newBook);
    }

    // HTTP DELETE Request
    // ROUTE: http://localhost:8080/api/v1/book/{bookId}
    @DeleteMapping(path = "{bookId}")
    public void removeBook(@PathVariable("bookId") Long bookId) {
        bookService.removeBook(bookId);
    }

    // HTTP PUT Request
    // ROUTE: http://localhost:8080/api/v1/book/{bookId}&title={newTitle}&author={author}&genre={newGenre}
    @PutMapping(path = "{bookId}")
    public void updateBook(@PathVariable("bookId") Long bookId, @RequestParam(required = false) String title,
                           @RequestParam(required = false) String author, @RequestParam(required = false) String genre) {
        bookService.updateBook(bookId, title, author, genre);
    }
}
