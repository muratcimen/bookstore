package com.muratcimen.bookstore.service;

import com.muratcimen.bookstore.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book finById(int theId);

    Book save(Book theBook);

    void deleteById(int theId);
}
