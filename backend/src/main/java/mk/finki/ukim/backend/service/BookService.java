package mk.finki.ukim.backend.service;

import mk.finki.ukim.backend.model.Book;
import mk.finki.ukim.backend.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id,BookDto bookDto);
    void deleteById(Long id);
    Optional<Book> availability(Long id);

}
