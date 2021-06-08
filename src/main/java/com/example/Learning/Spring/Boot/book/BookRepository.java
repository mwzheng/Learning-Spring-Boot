package com.example.Learning.Spring.Boot.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Interface responsible for data access
public interface BookRepository extends JpaRepository<Book, Long> { // <ClassName, id Type>

    // SELECT * FROM book WHERE title = <title>
    //@Query("SELECT s FROM Book s WHERE s.title = ?1")
    Optional<Book> findBookByTitle(String title);
}
