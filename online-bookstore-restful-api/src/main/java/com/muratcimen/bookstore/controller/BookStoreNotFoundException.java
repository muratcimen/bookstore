package com.muratcimen.bookstore.controller;

public class BookStoreNotFoundException extends RuntimeException{

    public BookStoreNotFoundException(String message) {
        super(message);
    }

    public BookStoreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStoreNotFoundException(Throwable cause) {
        super(cause);
    }
}
