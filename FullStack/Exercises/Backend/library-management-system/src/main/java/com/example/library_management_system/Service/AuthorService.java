package com.example.library_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_management_system.Exceptions.DuplicateEntryException;
import com.example.library_management_system.Exceptions.EntityNotFoundException;
import com.example.library_management_system.Model.Author;
import com.example.library_management_system.Repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + id));
    }

    public Author addAuthor(Author author) {
        // Check duplicate author by name
        authorRepository.findByNameIgnoreCase(author.getName())
            .ifPresent(existingAuthor -> {
                throw new DuplicateEntryException("Author with name " + author.getName() + " already exists");
            });
        
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author authorDetails) {
        Author existingAuthor = getAuthorById(id);

        // If name changed, check for duplicate author by name
        if (!authorDetails.getName().equalsIgnoreCase(existingAuthor.getName())) {
            authorRepository.findByNameIgnoreCase(authorDetails.getName())
                .ifPresent(author -> {
                        throw new DuplicateEntryException(
                                "Author with name " + authorDetails.getName() + " already exists");
                });
        }

        existingAuthor.setName(authorDetails.getName());
        existingAuthor.setNationality(authorDetails.getNationality());
        return authorRepository.save(existingAuthor);

    }

    public void deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }

    public List<Author> searchAuthors(String name, String nationality) {
        // If both name and nationality provided
        if (name != null && !name.isEmpty() && nationality != null && !nationality.isEmpty()) {
            return authorRepository.findByNameContainingIgnoreCase(name)
                    .stream()
                    .filter(author -> author.getNationality().equalsIgnoreCase(nationality))
                    .toList();
        }

        // If only name provided
        if (name != null && !name.isEmpty()) {
            return authorRepository.findByNameContainingIgnoreCase(name);
        }

        // If only nationality provided
        if (nationality != null && !nationality.isEmpty()) {
            return authorRepository.findByNationalityIgnoreCase(nationality);
        }

        return authorRepository.findAll();
    }
}
