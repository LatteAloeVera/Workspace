package com.ayberk.library_management_system.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayberk.library_management_system.Model.Book;
import com.ayberk.library_management_system.Service.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<Map<Long, Object>> getAllBooks(@RequestParam int page, @RequestParam int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(bookService.getAllBooks(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        return ResponseEntity.ok(Map.of("title", book.getTitle(),
                "category", book.getCategory(),
                "author", Map.of(
                        "id", book.getAuthor().getId(),
                        "name", book.getAuthor().getName()),
                "publicationDate", book.getPublicationDate()));
    }

    @PostMapping
    public ResponseEntity<String> createNewBook(@RequestBody Book book) {
        Book createdBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book successfully created: " + createdBook.getTitle());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Map<Long, Object>> searchBooks(
            @RequestParam String title,
            @RequestParam String authorName,
            @RequestParam String category) {

        List<Book> books = bookService.searchBooks(title, authorName, category);
        Map<Long, Object> bookMap = books.stream().collect(Collectors.toMap(Book::getId, book -> {
            return Map.of(
                    "title", book.getTitle(),
                    "category", book.getCategory(),
                    "author", Map.of(
                            "id", book.getAuthor().getId(),
                            "name", book.getAuthor().getName()),
                    "publicationDate", book.getPublicationDate());
        }));

        return ResponseEntity.ok(bookMap);

    }
}
