package se.lexicon.booklender.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false)
    private String title;

    private int maxLoanDays;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "books_authors",joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;
    public Book(String isbn, String title,int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }
}
