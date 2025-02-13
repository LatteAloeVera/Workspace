package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Book;
import com.example.library.model.BorrowRecord;
import com.example.library.model.User;

import java.util.List;
import java.util.Optional;



@Repository
public interface BorrowRepository extends JpaRepository<BorrowRecord,Long>{
    Optional<BorrowRecord> findByBookIdAndReturnedAtIsNull(Long bookId);
    Optional<BorrowRecord> findByUserAndBookAndReturnedAtIsNull(User user, Book book);
}
