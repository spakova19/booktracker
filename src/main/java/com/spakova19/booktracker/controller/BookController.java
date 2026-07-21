package com.spakova19.booktracker.controller;

import com.spakova19.booktracker.dto.CreateBookRequest;
import com.spakova19.booktracker.entity.Book;
import com.spakova19.booktracker.repository.BookRepository;
import com.spakova19.booktracker.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/createBook")
    public Book createBook(@RequestBody CreateBookRequest book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/booksByAuthorId/{id}")
    public List<Book> getBooksByAuthorId(@PathVariable Long id) {
        return bookService.getBooksByAuthorId(id);
    }

    @GetMapping("/bookById/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/bookByTitle")
    public Optional<Book> getBookByTitle(@RequestParam String title) {
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/bookByIsbn")
    public Optional<Book> getBookByIsbn(@RequestParam String isbn) {
        return  bookService.getBookByIsbn(isbn);
    }
}
