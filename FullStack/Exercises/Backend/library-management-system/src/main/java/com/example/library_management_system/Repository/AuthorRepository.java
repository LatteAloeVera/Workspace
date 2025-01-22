package com.example.library_management_system.Repository;

import com.example.library_management_system.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // For partial name search
    List<Author> findByNameContainingIgnoreCase(String name);

    // For exact match search by nationality (case-insensitive)
    List<Author> findByNationalityIgnoreCase(String nationality);

    // For duplicate check
    Optional<Author> findByNameIgnoreCase(String name);
}
