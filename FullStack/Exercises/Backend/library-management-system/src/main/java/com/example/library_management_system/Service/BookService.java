package com.example.library_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_management_system.Exceptions.DuplicateEntryException;
import com.example.library_management_system.Exceptions.EntityNotFoundException;
import com.example.library_management_system.Model.Book;
import com.example.library_management_system.Repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Couldn't find any book with id: " + id + " "));
    }

    public Book addBook(Book book) {
        bookRepository.findByTitleIgnoreCase(book.getTitle())
                .ifPresent(existingBook -> {
                    throw new DuplicateEntryException("Book with title " + book.getTitle() + " already exists");
                });

        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book existingBook = getBookById(id);

        if (!existingBook.getTitle().equalsIgnoreCase(bookDetails.getTitle())) {
            bookRepository.findByTitleIgnoreCase(bookDetails.getTitle())
                    .ifPresent(book -> {
                        throw new DuplicateEntryException(
                                "Book with title " + bookDetails.getTitle() + " already exists");
                    });
        }

        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setCategory(bookDetails.getCategory());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setPublicationDate(bookDetails.getPublicationDate());

        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

    public List<Book> searchBooks(String title, String authorName, String category) {
        // if all parameters are provided:
        if (title != null && !title.isEmpty() && authorName != null && !authorName.isEmpty()
                && category != null && !category.isBlank()) {
            return bookRepository.findByTitleContainingIgnoreCase(title)
                    .stream()
                    .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                    .filter(book -> book.getCategory().equalsIgnoreCase(category))
                    .toList();
        }

        // if both title and author provided:
        if (title != null && !title.isEmpty() && authorName != null && !authorName.isEmpty()) {
            return bookRepository.findByTitleContainingIgnoreCase(title)
                    .stream()
                    .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                    .toList();
        }

        // if both author and category provided:
        if (authorName != null && !authorName.isEmpty() && category != null && !category.isBlank()) {
            return bookRepository.findByCategoryContainingIgnoreCase(category)
                    .stream()
                    .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                    .toList();
        }

        // if both title and category provided:
        if (title != null && !title.isEmpty() && category != null && !category.isBlank()) {
            return bookRepository.findByTitleContainingIgnoreCase(title)
                    .stream()
                    .filter(book -> book.getCategory().equalsIgnoreCase(category))
                    .toList();
        }

        // if only title provided:
        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitleContainingIgnoreCase(title);
        }

        // if only author provided:
        if (authorName != null && !authorName.isEmpty()) {
            return bookRepository.findAll()
                    .stream()
                    .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                    .toList();
        }

        // if only category provided:
        if (category != null && !category.isBlank()) {
            return bookRepository.findByCategoryContainingIgnoreCase(category);
        }

        // if nothing given:
        return bookRepository.findAll();

    }
}
