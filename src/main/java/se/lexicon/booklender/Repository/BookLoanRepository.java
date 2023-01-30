package se.lexicon.booklender.Repository;

import org.springframework.data.repository.CrudRepository;

public interface BookLoanRepository extends CrudRepository<Boolean,Integer> {
}
