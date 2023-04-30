package mk.finki.ukim.backend.service.impl;

import mk.finki.ukim.backend.exceptions.AuthorNotFoundException;
import mk.finki.ukim.backend.model.Author;
import mk.finki.ukim.backend.model.Country;
import mk.finki.ukim.backend.model.dto.AuthorDto;
import mk.finki.ukim.backend.repository.AuthorRepository;
import mk.finki.ukim.backend.repository.CountryRepository;
import mk.finki.ukim.backend.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getCountry())
                .orElseThrow(AuthorNotFoundException::new);
        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);

        return Optional.of(this.authorRepository.save(author));
    }
}
