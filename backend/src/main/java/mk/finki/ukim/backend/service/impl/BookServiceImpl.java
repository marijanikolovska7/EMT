package mk.finki.ukim.backend.service.impl;

import mk.finki.ukim.backend.exceptions.AuthorNotFoundException;
import mk.finki.ukim.backend.exceptions.BookNotFoundException;
import mk.finki.ukim.backend.model.Author;
import mk.finki.ukim.backend.model.Book;
import mk.finki.ukim.backend.model.Category;
import mk.finki.ukim.backend.model.dto.BookDto;
import mk.finki.ukim.backend.repository.AuthorRepository;
import mk.finki.ukim.backend.repository.BookRepository;
import mk.finki.ukim.backend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Category bookCategory = Category.valueOf(bookDto.getCategory());
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(ArithmeticException::new);
        Book book = new Book(bookDto.getName(), bookDto.getAvailableCopies(),author, bookCategory,true);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);
        book.setAuthor(author);
        book.setCategory(Category.valueOf(bookDto.getCategory()));
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setName(bookDto.getName());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> availability(Long id) {
        Book bookChange = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        Integer copies = bookChange.getAvailableCopies();
        if(copies > 0){
            bookChange.setAvailableCopies(--copies);
            if(copies == 0){
                bookChange.setAvailable(false);
            }
        }
        this.bookRepository.save(bookChange);
        return Optional.of(bookChange);
    }
}
