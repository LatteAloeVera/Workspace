package com.example.library.model;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A User can have many borrow records, but each borrow record is associated with one User.
    @ManyToOne
    private User user;

    // A Book can have many borrow records, but each borrow record is associated with one Book.
    @OneToOne
    private Book book;

    private LocalDateTime borrowedAt;
    private LocalDateTime returnedAt;

    public BorrowRecord() {
    }

    public BorrowRecord(User user, Book book, LocalDateTime borrowedAt, LocalDateTime returnedAt) {
        this.user = user;
        this.book = book;
        this.borrowedAt = borrowedAt;
        this.returnedAt = returnedAt;
    }
}
