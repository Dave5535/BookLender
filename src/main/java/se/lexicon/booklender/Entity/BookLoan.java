package se.lexicon.booklender.Entity;

import java.lang.management.GarbageCollectorMXBean;
import java.time.LocalDate;
import java.util.List;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;
@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private AppUser borrower;

@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
private Book book;

    public BookLoan(LocalDate loanDate, AppUser borrower, Book book) {

        this.loanDate = loanDate;
        this.dueDate = loanDate.plusDays(book.getMaxLoanDays());
        this.book = book;
        this.borrower = borrower;
    }
    public void setBorrower(AppUser borrower){
        this.borrower = borrower;
        this.returned = (borrower == null);
    }
}
