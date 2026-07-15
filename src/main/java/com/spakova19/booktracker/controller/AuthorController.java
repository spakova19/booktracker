package com.spakova19.booktracker.controller;

import com.spakova19.booktracker.entity.Author;
import com.spakova19.booktracker.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/createAuthor")
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @GetMapping("/allAuthors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/authorById/{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id) {
        return authorRepository.findById(id);
    }

    @GetMapping("/authorByName")
    public Optional<Author> getAuthorByName(@RequestParam String name) {
        return authorRepository.findByName(name);
    }
}
