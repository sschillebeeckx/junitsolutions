package be.abis.exercise.test;

import be.abis.exercise.exception.PersonShouldBeAdultException;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    Person p1;

    @BeforeEach
    void setUp(){
        int birthYear = LocalDate.now().minusYears(42).getYear();
        p1 = new Person(1,"Ann","Smits", LocalDate.of(birthYear, 6, 28));
    }

    @Test
    void person1ShouldBe42YearsOld() throws PersonShouldBeAdultException {
       assertThat(p1.calculateAge(), is(equalTo(42)));
    }

    @Test
    public void personUnder18ShouldThrowException() {
        Person p2 = new Person(2,"John","Doe",this.calculateBoundaryBDforException());
        assertThrows(PersonShouldBeAdultException.class,()->p2.calculateAge());
    }

    @Test
    public void toStringSentenceStartsWithPerson(){
        String sentence = p1.toString();
        assertThat(sentence, startsWith("Person"));
    }

    private LocalDate calculateBoundaryBDforException(){
        return LocalDate.now().minusYears(18).plusDays(1);
    }

}
