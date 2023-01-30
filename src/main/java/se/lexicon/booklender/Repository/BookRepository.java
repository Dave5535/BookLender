package se.lexicon.booklender.Repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.booklender.Entity.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
}
