package be.abis.exercise.test;

import be.abis.exercise.exception.PersonShouldBeAdultException;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    void person1ShouldBe42YearsOld() throws PersonShouldBeAdultException {
        int birthYear = LocalDate.now().minusYears(42).getYear();
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(birthYear, 6, 28));
        assertEquals(42,p1.calculateAge()); //correct value
    }
}
