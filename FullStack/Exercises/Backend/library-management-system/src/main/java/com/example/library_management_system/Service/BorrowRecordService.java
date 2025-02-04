package com.example.library_management_system.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_management_system.Exceptions.DuplicateEntryException;
import com.example.library_management_system.Exceptions.EntityNotFoundException;
import com.example.library_management_system.Model.Book;
import com.example.library_management_system.Model.BorrowRecord;
import com.example.library_management_system.Repository.BorrowRecordRepository;

@Service
public class BorrowRecordService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private BookService bookService;

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    public BorrowRecord getBorrowRecordById(Long id) {
        return borrowRecordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Couldn't find any book with id: " + id + " "));
    }

    public BorrowRecord borrowBook(BorrowRecord record) {
        Book book = bookService.getBookById(record.getId());

        if (borrowRecordRepository.findByBookTitleIgnoreCase(book.getTitle())
                .filter(br -> !br.isReturned()).isPresent()) {
            throw new DuplicateEntryException("Book is already borrowed");
        }

        record.setBorrowDate(LocalDate.now());
        record.setReturned(false);
        return borrowRecordRepository.save(record);
    }

    public BorrowRecord returnBook(Long id, LocalDate returnDate) {
        Book book = bookService.getBookById(id);

        // if book record don't exists:
        if (!borrowRecordRepository.findByBookTitleIgnoreCase(book.getTitle()).isPresent()) {
            throw new EntityNotFoundException("Book is not borrowed!");
        }

        // if book is already returned:
        if (borrowRecordRepository.findByBookTitleIgnoreCase(book.getTitle())
                .filter(br -> br.isReturned()).isPresent()) {
            throw new DuplicateEntryException("Book is already returned!");
        }

        BorrowRecord borrowRecord = borrowRecordRepository.findByBookTitleIgnoreCase(book.getTitle()).get();
        borrowRecord.setReturnDate(returnDate);
        borrowRecord.setReturned(true);
        return borrowRecordRepository.save(borrowRecord);
    }

    public BorrowRecord updateBorrowRecord(Long id, BorrowRecord recordDetails) {
        BorrowRecord existingRecord = getBorrowRecordById(id);

        // Checking if book exists with the given title
        if (!existingRecord.getBook().getTitle().equalsIgnoreCase(recordDetails.getBook().getTitle())) {
            borrowRecordRepository.findByBookTitleIgnoreCase(recordDetails.getBook().getTitle())
                    .ifPresent(book -> {
                        throw new DuplicateEntryException(
                                "Borrow record with book " + recordDetails.getBook().getTitle() + " already exists");
                    });
        }

        existingRecord.setBook(recordDetails.getBook());
        existingRecord.setBorrowDate(recordDetails.getBorrowDate());
        existingRecord.setBorrowerName(recordDetails.getBorrowerName());
        existingRecord.setReturnDate(recordDetails.getReturnDate());
        existingRecord.setReturned(recordDetails.isReturned());

        return borrowRecordRepository.save(existingRecord);
    }

    public List<BorrowRecord> searchRecords(String borrowerName, String bookTitle) {
        // if both provided
        if (borrowerName != null && !borrowerName.isEmpty() && bookTitle != null && !bookTitle.isEmpty()) {
            return borrowRecordRepository.findByBorrowerNameContainingIgnoreCase(borrowerName)
                    .stream()
                    .filter(borrowRecord -> borrowRecord.getBook().getTitle().equalsIgnoreCase(bookTitle))
                    .toList();
        }

        // if only borrowerName provided
        if (borrowerName != null && !borrowerName.isEmpty()) {
            return borrowRecordRepository.findByBorrowerNameContainingIgnoreCase(borrowerName);
        }

        // if only bookTitle provided
        if (bookTitle != null && !bookTitle.isEmpty()) {
            return borrowRecordRepository.findByBookTitleContainingIgnoreCase(bookTitle);
        }

        // if nothing provided
        return getAllBorrowRecords();
    }
}
