package com.muratcimen.bookstore.service.impl;

import com.muratcimen.bookstore.dao.BookDAO;
import com.muratcimen.bookstore.entity.Book;
import com.muratcimen.bookstore.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    public BookServiceImpl(BookDAO theBookDAO) {
        bookDAO = theBookDAO;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book finById(int theId) {
        return bookDAO.finById(theId);
    }

    @Override
    @Transactional
    public Book save(Book theBook) {
        return bookDAO.save(theBook);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        bookDAO.deleteById(theId);
    }
}
