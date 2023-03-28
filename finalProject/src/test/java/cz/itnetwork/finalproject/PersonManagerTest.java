package cz.itnetwork.finalproject;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author petra
 */
class PersonManagerTest {

    private PersonManager personManager;

    @BeforeEach
    void setUp() {
        personManager = new PersonManager();
    }

    @Test
    void testGetEmpty() {
        assertTrue(personManager.getAll().isEmpty());
    }

    @Test
    void testGetPersons() {
        Person person = new Person("Antonín", "Nový", "+420723123123", 55);
        Person person2 = new Person("Martin", "Starý", "+420723111555", 30);

        personManager.addPerson("Antonín", "Nový", "+420723123123", 55);
        personManager.addPerson("Martin", "Starý", "+420723111555", 30);

        List<Person> persons = personManager.getAll();

        assertEquals(persons.size(), 2);
        assertEquals(persons.get(0), person);
        assertEquals(persons.get(1), person2);
    }
    
    @Test
    void testFindPerson() {
        Person person = new Person("Honza", "Novák", "+420723555888", 18);

        personManager.addPerson("Jan", "Honza", "+420723555777", 18);
        personManager.addPerson("Honza", "Novák", "+420723555888", 18);
        personManager.addPerson("Honza", "Nový", "+420723555333", 77);

        List<Person> persons = personManager.findByNameAndSurname("Honza", "Novák");

        assertEquals(persons.size(), 1);
        assertEquals(persons.get(0), person);
    }
}
