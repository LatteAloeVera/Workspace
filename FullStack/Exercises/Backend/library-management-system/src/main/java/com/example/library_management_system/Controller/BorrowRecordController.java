package com.example.library_management_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_management_system.Model.BorrowRecord;
import com.example.library_management_system.Service.BorrowRecordService;
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
    public ResponseEntity<BorrowRecord> borrowBook(@RequestBody BorrowRecord record) {
        return ResponseEntity.status(HttpStatus.CREATED).body(borrowRecordService.borrowBook(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowRecord> returnBook(@PathVariable Long id, @RequestBody BorrowRecord record) {
        return ResponseEntity.ok(borrowRecordService.updateBorrowRecord(id, record));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BorrowRecord>> searchBorrowRecords(
            @RequestParam String borrowerName,
            @RequestParam String bookTitle) {
        return ResponseEntity.ok(borrowRecordService.searchRecords(borrowerName, bookTitle));
    }

}
