package com.ayberk.library_management_system.Controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayberk.library_management_system.Model.BorrowRecord;
import com.ayberk.library_management_system.Service.BorrowRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/borrow-records")
public class BorrowRecordController {
    @Autowired
    BorrowRecordService borrowRecordService;

    @GetMapping
    public ResponseEntity<List<BorrowRecord>> getAllBorrowRecords() {
        return ResponseEntity.ok(borrowRecordService.getAllBorrowRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowRecord> getBorrowRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(borrowRecordService.getBorrowRecordById(id));
    }

    @PostMapping
    public ResponseEntity<String> borrowBook(@RequestBody BorrowRecord record) {
        BorrowRecord brwRecord = borrowRecordService.borrowBook(record);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book named \"" + brwRecord.getBook().getTitle()
                + "\" successfully borrowed by \"" + brwRecord.getBorrowerName() + "\".");
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> returnBook(@PathVariable Long id) {
        BorrowRecord brwRecord = borrowRecordService.returnBook(id, LocalDate.now());
        return ResponseEntity
                .ok("The book named \"" + brwRecord.getBook().getTitle() + "\" has been successfully returned.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBorrowRecord(@PathVariable Long id, @RequestBody BorrowRecord record) {
        BorrowRecord updatedBrwRecord = borrowRecordService.updateBorrowRecord(id, record);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Borrow record with id:" + updatedBrwRecord.getId() + " has successfully updated!");
    }

    @GetMapping("/search")
    public ResponseEntity<Map<Long, Object>> searchBorrowRecords(
            @RequestParam String borrowerName,
            @RequestParam String bookTitle) {

        List<BorrowRecord> borrowRecordList = borrowRecordService.searchRecords(borrowerName, bookTitle);
        Map<Long, Object> borrowRecordMap = new HashMap<>();

        for (BorrowRecord borrowRecord : borrowRecordList) {
            Map<String, Object> recordDetails = new HashMap<>();
            recordDetails.put("bookId", borrowRecord.getBook().getId());
            recordDetails.put("title", borrowRecord.getBook().getTitle());
            recordDetails.put("borrowerName", borrowRecord.getBorrowerName());
            recordDetails.put("borrowDate", borrowRecord.getBorrowDate());
            recordDetails.put("returnDate", borrowRecord.getReturnDate());
            recordDetails.put("isReturned", borrowRecord.isReturned());

            borrowRecordMap.put(borrowRecord.getId(), recordDetails);
        }
        return ResponseEntity.ok(borrowRecordMap);
    }

}
