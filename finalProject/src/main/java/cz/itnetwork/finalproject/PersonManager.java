package cz.itnetwork.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author petra
 */
public class PersonManager {

    private List<Person> persons = new ArrayList<>();

    public void addPerson(String name, String surname, String phoneNumber, int age) {
        Person person = new Person(name, surname, phoneNumber, age);
        persons.add(person);
    }

    public List<Person> findByNameAndSurname(String name, String surname) {
        return persons.stream()
                .filter(person -> person.getName().equals(name) && person.getSurname().equals(surname))
                .collect(Collectors.toList());
    }

    public List<Person> getAll() {
        return persons;
    }
}
