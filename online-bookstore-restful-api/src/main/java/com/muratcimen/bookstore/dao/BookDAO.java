package com.muratcimen.bookstore.dao;

import com.muratcimen.bookstore.entity.Book;

import java.util.List;

public interface BookDAO {

    List<Book> findAll();

    Book finById(int theId);

    Book save(Book theBook);

    void deleteById(int theId);
}
