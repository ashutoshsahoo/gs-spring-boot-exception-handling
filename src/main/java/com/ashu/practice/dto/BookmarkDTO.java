package com.ashu.practice.dto;

import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;

public record BookmarkDTO(
        Long id,
        @NotEmpty(message = "Title is mandatory")
        String title,
        @NotEmpty(message = "Url is mandatory")
        String url,
        Instant createdAt) {
}
