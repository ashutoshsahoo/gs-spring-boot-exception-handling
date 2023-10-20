package com.ashu.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;

public record BookmarkDTO(
        @Schema(description = "Unique Identifier", example = "1001",
                // not required in request but will be shown in response
                accessMode = Schema.AccessMode.READ_ONLY)
        Long id,
        @NotEmpty(message = "Title is mandatory")
        @Schema(description = "Bookmark title", example = "A very Good book")
        String title,
        @NotEmpty(message = "Url is mandatory")
        @Schema(description = "Bookmark URL", example = "https://www.text.com")
        String url,
        @Schema(description = "Creation timestamp")
        Instant createdAt) {
}
