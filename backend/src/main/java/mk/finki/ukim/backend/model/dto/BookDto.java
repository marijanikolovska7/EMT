package mk.finki.ukim.backend.model.dto;

import lombok.Data;
import mk.finki.ukim.backend.model.Category;

@Data
public class BookDto {
    private String name;
    private String category;
    private Integer availableCopies;
    private Long author;

    public BookDto() {
    }

    public BookDto(String name, String category, Integer availableCopies, Long author) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }
}
