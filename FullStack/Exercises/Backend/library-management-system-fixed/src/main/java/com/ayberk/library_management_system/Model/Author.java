package com.ayberk.library_management_system.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "authors") // Good practice to name tables explicitly
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(nullable = false)
    private String name;

    @Getter
    @NotBlank(message = "Nationality is mandatory")
    @Column(nullable = false)
    private String nationality;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    public Author() {
    }

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }
}
