package se.lexicon.booklender.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.booklender.Entity.Author;
@Repository
public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
