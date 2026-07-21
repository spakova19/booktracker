package com.spakova19.booktracker.service;

import com.spakova19.booktracker.dto.CreateBookRequest;
import com.spakova19.booktracker.entity.Author;
import com.spakova19.booktracker.entity.Book;
import com.spakova19.booktracker.repository.AuthorRepository;
import com.spakova19.booktracker.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(CreateBookRequest book) {
        Book result = new Book(
                book.getTitle(),
                book.getNumberOfPages(),
                book.getIsbn()
        );

        Author author = authorRepository.findById(book.getAuthorId()).orElseThrow();
        result.setAuthor(author);

        return bookRepository.save(result);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByAuthorId(Long id) {
        return bookRepository.findBooksByAuthorId(id);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        return  bookRepository.findByIsbn(isbn);
    }
}
