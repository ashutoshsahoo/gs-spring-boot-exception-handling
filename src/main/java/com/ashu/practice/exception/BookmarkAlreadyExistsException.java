package com.ashu.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

public class BookmarkAlreadyExistsException extends ErrorResponseException {
    public BookmarkAlreadyExistsException(String title) {
        super(HttpStatus.BAD_REQUEST,
                asProblemDetail("Bookmark with id " + title + " already exists"),
                null);
    }

    private static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, message);
        problemDetail.setTitle("Bookmark already exists");
        problemDetail.setType(URI.create("https://api.bookmarks.com/errors/already-exists"));
        problemDetail.setProperty("errorCategory", "Already Exists");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
