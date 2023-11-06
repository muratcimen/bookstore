package com.muratcimen.bookstore.dao.impl;

import com.muratcimen.bookstore.dao.BookDAO;
import com.muratcimen.bookstore.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOJpaImpl implements BookDAO {
    private EntityManager entityManager;

    @Autowired
    public BookDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> theQuery = entityManager.createQuery("from Book", Book.class);
        List<Book> books = theQuery.getResultList();
        return books;
    }

    @Override
    public Book finById(int theId) {
        Book book = entityManager.find(Book.class, theId);
        return book;
    }

    @Override
    public Book save(Book theBook) {
        Book dbBook = entityManager.merge(theBook);
        return dbBook;
    }

    @Override
    public void deleteById(int theId) {
        Book book = entityManager.find(Book.class, theId);
        entityManager.remove(book);
    }
}
