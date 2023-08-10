package lt.codeacademy.bookstore.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Book> books;
}

