package com.example.library_management_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "borrow_records")
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @NotBlank(message = "Borrower name is mandatory")
    @Column(nullable = false)
    private String borrowerName;

    @NotNull(message = "Borrow date is mandatory")
    @Column(nullable = false)
    private LocalDate borrowDate;

    // returnDate can be null if not returned yet
    private LocalDate returnDate;

    private boolean isReturned;

    public BorrowRecord() {
    }

    public BorrowRecord(Book book, String borrowerName, LocalDate borrowDate) {
        this.book = book;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        this.isReturned = false;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
