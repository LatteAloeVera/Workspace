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

}
