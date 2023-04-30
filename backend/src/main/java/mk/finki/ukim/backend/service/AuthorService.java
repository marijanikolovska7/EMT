package mk.finki.ukim.backend.service;

import mk.finki.ukim.backend.model.Author;
import mk.finki.ukim.backend.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(AuthorDto authorDto);
}
