package mk.finki.ukim.backend.service.impl;

import mk.finki.ukim.backend.model.Country;
import mk.finki.ukim.backend.repository.CountryRepository;
import mk.finki.ukim.backend.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country =  new Country(name,continent);
        countryRepository.save(country);
        return Optional.of(country);
    }
}
