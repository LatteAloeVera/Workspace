package com.example.library_management_system.Repository;

import com.example.library_management_system.Model.Book;
import com.example.library_management_system.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Partial match on title
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Exact match on title
    Optional<Book> findByTitleIgnoreCase(String title);

    // Exact match on category (case-insensitive)
    List<Book> findByCategoryIgnoreCase(String category);

    // Duplicate check - same title + same author
    Optional<Book> findByTitleIgnoreCaseAndAuthor(String title, Author author);
}
