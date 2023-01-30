package se.lexicon.booklender.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.booklender.Entity.Details;
@Repository
public interface DetailsRepository extends CrudRepository<Details,Integer> {
}
