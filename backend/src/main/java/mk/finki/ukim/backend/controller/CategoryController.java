package mk.finki.ukim.backend.controller;

import mk.finki.ukim.backend.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {
    @GetMapping("")
    public List<Category> getBooks(){
        return List.of(Category.values());
    }
}
