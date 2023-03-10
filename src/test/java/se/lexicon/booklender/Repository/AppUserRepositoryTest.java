package se.lexicon.booklender.Repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.booklender.Entity.AppUser;
import se.lexicon.booklender.Entity.Details;

import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
public class AppUserRepositoryTest {


    @Autowired
    AppUserRepository testObject;
    AppUser createdAppUser;
    @BeforeEach
    public void setup(){
        Details detailsData = new Details("user@test","Test Test", LocalDate.parse("2000-01-01"));
        AppUser appUserData = new AppUser("user","password", detailsData);
        createdAppUser = testObject.save(appUserData);
        assertNotNull(createdAppUser);
    }


    @Test
    public void test_findById(){
        Optional<AppUser> appUserOptional = testObject.findById(createdAppUser.getId());
        assertTrue(appUserOptional.isPresent());
        AppUser actualData = appUserOptional.get();
        AppUser expectedData = createdAppUser;
        assertEquals(expectedData, actualData);

    }
}
