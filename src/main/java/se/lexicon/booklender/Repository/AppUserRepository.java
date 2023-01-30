package se.lexicon.booklender.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.booklender.Entity.AppUser;
@Repository
public interface AppUserRepository extends CrudRepository<AppUser,Integer> {
}
