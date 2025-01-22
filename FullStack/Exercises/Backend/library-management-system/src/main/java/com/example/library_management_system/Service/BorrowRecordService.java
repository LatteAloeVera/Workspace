package com.example.library_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library_management_system.Model.BorrowRecord;
import com.example.library_management_system.Repository.BorrowRecordRepository;

@Service
public class BorrowRecordService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    public BorrowRecord borrowBook(BorrowRecord record) {
        List<BorrowRecord> borrowRecords = getAllBorrowRecords();
        
    }
}
