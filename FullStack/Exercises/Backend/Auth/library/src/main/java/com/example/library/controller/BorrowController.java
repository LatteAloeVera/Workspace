package com.example.library.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.library.service.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    BorrowService borrowService;

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/{bookId}")
    public String borrowBook(@PathVariable Long bookId, @RequestAttribute("userId") Long userId) {
        return borrowService.borrowBook(userId, bookId);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/return/{bookId}")
    public String returnBook(@PathVariable Long bookId, @RequestAttribute("userId") Long userId) {
        return borrowService.returnBook(userId, bookId);
    }

}