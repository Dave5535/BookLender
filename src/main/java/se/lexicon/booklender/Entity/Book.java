package se.lexicon.booklender.Entity;

import lombok.*;
import se.lexicon.booklender.Exseption.DataDuplicateException;
import se.lexicon.booklender.Exseption.DataNotFoundException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    public Book(String isbn, String title,int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    public void addAuthor(Author author){
if (authors.contains(author))
    throw new DataDuplicateException("Data Duplicate Exception");
authors.add(author);

    }
    public void removeAuthor(Author author){
        if (!authors.contains(author))
            throw new DataNotFoundException("Data Not Found Exception");
        authors.remove(author);
    }
}
