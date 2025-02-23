package com.example.library.controller;

import com.example.library.dto.BookDTO;
import com.example.library.model.Book;
import com.example.library.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/books")
public class BookControllerNew {
    @Autowired
    BookService bookService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public String addBook(@RequestBody BookDTO bookDTO) {
        Book book = new Book(bookDTO.getTitle(), bookDTO.getAuthor(), false);
        bookService.addBook(book);

        return "Book added successfully!";
    }
    
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/list")
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

    

}