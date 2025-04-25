package be.abis.exercise.test;

import be.abis.exercise.exception.PersonShouldBeAdultException;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class PersonTest {

    @Test
    void person1ShouldBe42YearsOld() throws PersonShouldBeAdultException {
        int birthYear = LocalDate.now().minusYears(42).getYear();
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(birthYear, 3, 28));
        assertThat(p1.calculateAge(), is(equalTo(42)));
    }


    @Test
    public void toStringSentenceStartsWithPerson(){
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(1980, 6, 28));
        String sentence = p1.toString();
        assertThat(sentence, startsWithIgnoringCase("Person"));
    }

}
