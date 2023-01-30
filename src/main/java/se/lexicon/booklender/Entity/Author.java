package se.lexicon.booklender.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "books_authors",joinColumns = @JoinColumn(name = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
private Set<Book> writtenBooks;
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
