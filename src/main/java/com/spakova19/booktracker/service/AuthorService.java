package com.spakova19.booktracker.service;

import com.spakova19.booktracker.entity.Author;
import com.spakova19.booktracker.repository.AuthorRepository;
import com.spakova19.booktracker.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public void deleteAuthorById(Long id) {
        bookRepository.deleteByAuthorId(id);
        authorRepository.deleteById(id);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Optional<Author> getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }
}
