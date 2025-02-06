package com.ayberk.library_management_system.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ayberk.library_management_system.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ayberk.library_management_system.Exceptions.DuplicateEntryException;
import com.ayberk.library_management_system.Exceptions.EntityNotFoundException;
import com.ayberk.library_management_system.Model.Book;
import com.ayberk.library_management_system.Repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Map<Long, Object> getAllBooks(PageRequest pageable) {
        List<Book> books = bookRepository.findAll(pageable).toList();
        Map<Long, Object> bookMap = books.stream().collect(Collectors.toMap(Book::getId, book -> {
            return Map.of(
                    "title", book.getTitle(),
                    "category", book.getCategory(),
                    "author", Map.of(
                            "id", book.getAuthor().getId(),
                            "name", book.getAuthor().getName()),
                    "publicationDate", book.getPublicationDate());
        }));
        return bookMap;
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

        // if author is not in the database, throw an exception
        authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Couldn't find any author with id: " + book.getAuthor().getId() + " "));

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
