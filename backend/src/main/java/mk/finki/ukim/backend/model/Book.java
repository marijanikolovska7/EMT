package mk.finki.ukim.backend.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer availableCopies;
    @ManyToOne
    private Author author;
    @Enumerated(EnumType.STRING)
    private Category category;
    private boolean isAvailable;
    public Book() {
    }
    public Book(String name, Integer availableCopies, Author author, Category category,boolean isAvailable) {
        this.name = name;
        this.availableCopies = availableCopies;
        this.author = author;
        this.category = category;
        this.isAvailable = isAvailable;
    }
}
