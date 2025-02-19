package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.BorrowRecord;
import com.example.library.model.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowRepository;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BorrowService {
    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    public String borrowBook(Long userId, Long bookId) {
        // Checking if user exists
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return "User not found.";
        }
        User u = user.get();

        // Checking if book exists
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isEmpty()) {
            return "Book not found.";
        }
        Book b = book.get();

        // Checking if book is already borrowed or not
        if (borrowRepository.findByBookIdAndReturnedAtIsNull(bookId).isPresent()) {
            return "Book named \"" + b.getTitle() + "\" is already borrowed";
        }

        BorrowRecord newRecord = new BorrowRecord();
        newRecord.setBook(b);
        newRecord.setUser(u);
        newRecord.setBorrowedAt(LocalDateTime.now());

        borrowRepository.save(newRecord);
        return "Book borrowed successfully!";
    }

    public String returnBook(Long userId, Long bookId) {
        // Checking if user exists
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return "User not found.";
        }
        User u = user.get();

        // Checking if book exists
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isEmpty()) {
            return "Book not found.";
        }
        Book b = book.get();

        Optional<BorrowRecord> borrowRecord = borrowRepository.findByUserAndBookAndReturnedAtIsNull(u, b);
        if (borrowRecord.isEmpty()) {
            return "This book is not borrowed by this user";
        }
        BorrowRecord updatedRecord = borrowRecord.get();

        updatedRecord.setReturnedAt(LocalDateTime.now());
        borrowRepository.save(updatedRecord);
        return "Book returned successfully!";
    }
}
