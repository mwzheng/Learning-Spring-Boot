package com.example.Learning.Spring.Boot.book;

import javax.persistence.*;

// Model for a 'Book' table with rows: id, title,
// author, pages, generes and copiesAvailable

@Entity(name = "Book") // Defaults to className
@Table(name = "book") // Signifies that class will be a table
public class Book {
    @Id // Used to specify that id will be the primary key for the table
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence",
            allocationSize = 1 // Increase id by 1 each time
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(name = "author", nullable = false, columnDefinition = "TEXT")
    private String author;

    @Column(name = "pages", nullable = false, columnDefinition = "TEXT")
    private int pages;

    @Column(name = "genre", nullable = false, columnDefinition = "TEXT")
    private String genres;

    @Column(name = "copies", nullable = false)
    private int copiesAvailable;

    // Must have default constructor or won't run
    public Book() {
    }

    public Book(String title, String author, int pages, String genres, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genres = genres;
        this.copiesAvailable = copiesAvailable;
    }

    public boolean hasCopiesAvailable() {
        return this.copiesAvailable != 0;
    }

    public void addBook(int newCopies) {
        this.copiesAvailable += newCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getGenres() {
        return genres;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    // Two books are equal if they have the same title & author
    public boolean isEqual(Object o) {
        if (!(o instanceof Book)) return false;
        Book otherBook = (Book) o;
        return this.title.equals(otherBook.getTitle()) && this.getAuthor().equals(otherBook.getAuthor());
    }

    public String toString() {
        return "Title: " + title + ", " + "Author: " + author + ", # Pages: " + pages + ", Genres: " + genres +
                ", Copies Available: " + copiesAvailable;
    }
}
