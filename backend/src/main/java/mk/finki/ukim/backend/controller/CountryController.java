package mk.finki.ukim.backend.controller;

import mk.finki.ukim.backend.model.Country;
import mk.finki.ukim.backend.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    public List<Country> findAll()
    {
        return this.countryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestParam String name,
                                        @RequestParam String continent){
        return this.countryService.save(name,continent)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
