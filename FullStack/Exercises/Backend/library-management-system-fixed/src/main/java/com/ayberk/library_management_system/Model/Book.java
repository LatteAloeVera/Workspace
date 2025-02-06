package com.ayberk.library_management_system.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Category is mandatory")
    @Column(nullable = false)
    private String category;

    @NotNull(message = "Publication date is mandatory")
    @PastOrPresent(message = "Publication date cannot be in the future")
    @Column(nullable = false)
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book() {
    }

    public Book(Long id) {
        
    }

    public Book(String title, String category, LocalDate publicationDate, Author author) {
        this.title = title;
        this.category = category;
        this.publicationDate = publicationDate;
        this.author = author;
    }

}
