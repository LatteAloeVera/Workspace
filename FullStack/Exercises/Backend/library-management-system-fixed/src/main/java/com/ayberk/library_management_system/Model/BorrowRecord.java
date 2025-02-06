package com.ayberk.library_management_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public BorrowRecord(Book book, String borrowerName) {
        this.book = book;
        this.borrowerName = borrowerName;
    }

}
