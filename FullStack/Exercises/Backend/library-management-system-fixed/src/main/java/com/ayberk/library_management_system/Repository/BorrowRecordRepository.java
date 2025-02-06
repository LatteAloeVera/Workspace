package com.ayberk.library_management_system.Repository;

import com.ayberk.library_management_system.Model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {

        // Search by borrower name
        List<BorrowRecord> findByBorrowerNameContainingIgnoreCase(String borrowerName);

        // Search by book title via JPQL join
        @Query("SELECT br FROM BorrowRecord br JOIN br.book b " +
                        "WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
        List<BorrowRecord> findByBookTitleContainingIgnoreCase(@Param("title") String title);

        // Search by exact book title via JPQL join
        @Query("SELECT br FROM BorrowRecord br JOIN br.book b " +
                        "WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
        Optional<BorrowRecord> findByBookTitleIgnoreCase(@Param("title") String title);
}
