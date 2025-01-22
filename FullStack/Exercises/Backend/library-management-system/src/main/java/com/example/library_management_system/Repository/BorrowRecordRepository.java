package com.example.library_management_system.Repository;

import com.example.library_management_system.Model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {

    // Search by borrower name
    List<BorrowRecord> findByBorrowerNameContainingIgnoreCase(String borrowerName);

    // Search by book title via JPQL join
    @Query("SELECT br FROM BorrowRecord br JOIN br.book b " +
           "WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<BorrowRecord> findByBookTitleContainingIgnoreCase(@Param("title") String title);
}
