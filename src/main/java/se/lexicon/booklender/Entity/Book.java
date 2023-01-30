package se.lexicon.booklender.Entity;

import lombok.*;

import javax.persistence.*;

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

    public Book(String isbn, String title,int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }
}
