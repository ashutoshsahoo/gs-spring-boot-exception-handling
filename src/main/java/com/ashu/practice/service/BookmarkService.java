package com.ashu.practice.service;

import com.ashu.practice.dto.BookmarkDTO;
import com.ashu.practice.exception.BookmarkAlreadyExistsException;
import com.ashu.practice.exception.BookmarkNotFoundException;
import com.ashu.practice.model.Bookmark;
import com.ashu.practice.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookmarkService {

    private final BookmarkRepository repo;

    public List<BookmarkDTO> getBookmarks() {
        return repo.findAll().stream().map(this::mapModelToDto).toList();
    }

    public BookmarkDTO getBookmarkById(Long id) {
        log.info("Request to find bookmark={}", id);
        var model = findBookmark(id);
        log.info("Found bookmark={}", model);
        return mapModelToDto(model);
    }

    private Bookmark findBookmark(Long id) {
        return repo.findById(id).orElseThrow(() -> new BookmarkNotFoundException(id));
    }

    public BookmarkDTO save(BookmarkDTO bookmarkDTO) {
        log.info("Request to save bookmark={}", bookmarkDTO);
        Optional<Bookmark> optionalBookmark = repo.findByTitle(bookmarkDTO.title());
        if (optionalBookmark.isPresent()) {
            throw new BookmarkAlreadyExistsException(bookmarkDTO.title());
        }
        var model = repo.save(mapDtoToModel(bookmarkDTO));
        log.info("Saved bookmark={}", model);
        return mapModelToDto(model);
    }

    public void deleteById(Long id) {
        var model = findBookmark(id);
        repo.delete(model);
    }

    private Bookmark mapDtoToModel(BookmarkDTO dto) {
        var model = new Bookmark();
        BeanUtils.copyProperties(dto, model, "id");
        return model;
    }

    private BookmarkDTO mapModelToDto(Bookmark model) {
        return new BookmarkDTO(
                model.getId(),
                model.getTitle(),
                model.getUrl(),
                model.getCreatedAt()
        );
    }
}
