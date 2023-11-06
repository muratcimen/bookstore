package com.muratcimen.bookstore.controller;

import com.muratcimen.bookstore.entity.Book;
import com.muratcimen.bookstore.service.BookService;
import com.muratcimen.config.RateLimited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService theBookService) {
        bookService = theBookService;
    }

    @RateLimited
    @GetMapping("/books")
    public List<Book> findAll() {
        List<Book> books = bookService.findAll();
        if (books.isEmpty()) {
            throw new BookStoreNotFoundException("No Books Found");
        }
        return books;
    }
    @RateLimited
    @GetMapping("/books/{isbn}")
    public Book getBook(@PathVariable int isbn) {
        Book book = bookService.finById(isbn);
        if (book == null) {
            throw new BookStoreNotFoundException("Book id not found -> " + isbn);
        }
        return book;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook) {
        Book dbBook = bookService.save(theBook);
        return dbBook;
    }

    @PutMapping("/books/{isbn}")
    public Book updateBook(@RequestBody Book theBook) {
        Book dbBook = bookService.save(theBook);
        return dbBook;
    }

    @DeleteMapping("/books/{isbn}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable int isbn) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"))) {
            throw new UnauthorizedAccessException("Unauthorized User!");
        }
        Book book = bookService.finById(isbn);
        if (book == null) {
            throw new BookStoreNotFoundException("Book id not found -> " + isbn);
        }
        bookService.deleteById(isbn);
        return "Deleted book id -> " + isbn;
    }
}
