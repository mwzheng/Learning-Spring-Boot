package com.example.Learning.Spring.Boot.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
            // Initial Db data on start
            bookRepository.saveAll(
                    List.of(
                            new Book("The Cat In The Hat", "Dr.Suess", 61, "Children,Picture", 3),
                            new Book("Fox in Sox", "Dr.Suess", 72, "Children,Picture", 2),
                            new Book("Green Eggs and Ham", "Dr.Suess", 62, "Children,Picture", 3),
                            new Book("The Giver", "Lois Lowry", 179, "Fiction,Utopian,YoungAdult", 1),
                            new Book("My Side Of The Mountain", "Jean Craighead George", 177, "Adventure,Novel,Fiction", 2)
                    )
            );
        };
    }

}
