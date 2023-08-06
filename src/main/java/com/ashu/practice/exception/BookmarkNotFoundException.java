package com.ashu.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

public class BookmarkNotFoundException extends ErrorResponseException {

    public BookmarkNotFoundException(Long bookmarkId) {
        super(HttpStatus.NOT_FOUND,
                asProblemDetail("Bookmark with id " + bookmarkId + " not found"),
                null);
    }

    private static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);
        problemDetail.setTitle("Bookmark Not Found");
        problemDetail.setType(URI.create("https://api.bookmarks.com/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Not Found");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}

