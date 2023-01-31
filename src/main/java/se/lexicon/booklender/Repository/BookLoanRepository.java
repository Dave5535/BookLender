package se.lexicon.booklender.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.booklender.Entity.BookLoan;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan,Integer> {
}
