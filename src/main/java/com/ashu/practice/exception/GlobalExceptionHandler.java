package com.ashu.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(BookmarkNotFoundException.class)
//    ErrorResponse handleBookmarkNotFoundException(BookmarkNotFoundException e) {
//        return ErrorResponse.builder(e, HttpStatus.NOT_FOUND, e.getMessage())
//                .title("Bookmark not found")
//                .type(URI.create("https://api.bookmarks.com/errors/not-found"))
//                .property("errorCategory", "Generic")
//                .property("timestamp", Instant.now())
//                .build();
//    }
}
