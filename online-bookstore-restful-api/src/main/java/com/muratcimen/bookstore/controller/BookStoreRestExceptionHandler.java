package com.muratcimen.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class BookStoreRestExceptionHandler {

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<BookStoreErrorResponse> handleException(BookStoreNotFoundException exc) {

        //create a BookStoreErrorResponse

        BookStoreErrorResponse error = new BookStoreErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BookStoreErrorResponse> handleException(UnauthorizedAccessException exc) {

        //create a BookStoreErrorResponse

        BookStoreErrorResponse error = new BookStoreErrorResponse();

        error.setStatus(HttpStatus.FORBIDDEN.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<BookStoreErrorResponse> handleException(ResponseStatusException exc) {

        //create a BookStoreErrorResponse

        BookStoreErrorResponse error = new BookStoreErrorResponse();

        error.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        error.setMessage("The request rate is limited! Please try again later.");
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.TOO_MANY_REQUESTS);
    }

    //Add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<BookStoreErrorResponse> handleException(Exception exc) {
        //create a BookStoreErrorResponse

        BookStoreErrorResponse error = new BookStoreErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
