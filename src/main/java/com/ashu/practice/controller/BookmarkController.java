package com.ashu.practice.controller;

import com.ashu.practice.dto.BookmarkDTO;
import com.ashu.practice.service.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService service;


    @PostMapping
    public ResponseEntity<BookmarkDTO> save(@Valid @RequestBody BookmarkDTO payload) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(payload));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookmarkDTO> getBookmarkById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBookmarkById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookmarkById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
