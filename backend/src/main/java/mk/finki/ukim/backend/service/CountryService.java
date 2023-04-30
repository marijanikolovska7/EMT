package mk.finki.ukim.backend.service;

import mk.finki.ukim.backend.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> save(String name, String continent);
}
