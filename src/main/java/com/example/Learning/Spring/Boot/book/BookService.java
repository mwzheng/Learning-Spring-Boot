package com.example.Learning.Spring.Boot.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// Class contains the 'business' logic for books
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get the list of all books in the database
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    // Add the new book if it doesn't exist, if it does, increase # copies
    public void addNewBook(Book newBook) {
        Optional<Book> optionalBook = bookRepository.findBookByTitle(newBook.getTitle());

        if (optionalBook.isPresent()) { // Book exist, increase copies
            Book existingBook = optionalBook.get();
            existingBook.addBook(newBook.getCopiesAvailable());
            System.out.println("Added new copies to: " + newBook.getTitle());
            bookRepository.save(existingBook);
        } else { // Add new book to database
            System.out.println(newBook);
            bookRepository.save(newBook);
        }
    }

    // Removes book with the given bookId from database
    public void removeBook(Long bookId) {
        boolean bookExist = bookRepository.existsById(bookId);

        if (!bookExist) {
            System.out.println("Book with id " + bookId + " doesn't exist");
        } else {
            bookRepository.deleteById(bookId);
        }
    }

    // Update book with given id
    @Transactional
    public void updateBook(Long bookId, String title, String author, String genre) {
        boolean bookExist = bookRepository.existsById(bookId);

        if (bookExist) {
            Book theBook = bookRepository.getById(bookId);
            if (author.length() > 0 && !theBook.getAuthor().equals(author)) theBook.setAuthor(author);
            if (title.length() > 0 && !theBook.getTitle().equals(title)) theBook.setTitle(title);
            if (genre.length() > 0 && !theBook.getGenres().equals(genre)) theBook.setGenres(genre);
        } else {
            System.out.println("Book with id " + bookId + " does not exist");
        }
    }
}
