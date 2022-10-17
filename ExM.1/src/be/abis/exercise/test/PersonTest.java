package be.abis.exercise.test;

import be.abis.exercise.exception.PersonShouldBeAdultException;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonTest {

    Person p1;
    @Mock
    Company mockCompany;

    @BeforeEach
    void setUp(){
        int birthYear = LocalDate.now().minusYears(42).getYear();
        p1 = new Person(1,"Ann","Smits", LocalDate.of(birthYear, 6, 28));
    }

    @Test
    @Order(3)
    void person1ShouldBe42YearsOld() throws PersonShouldBeAdultException {
       assertThat(p1.calculateAge(), is(equalTo(42)));
    }

    @Test
    @Order(2)
    public void personUnder18ShouldThrowException() {
        Person p2 = new Person(2,"John","Doe",this.calculateBoundaryBDforException());
        assertThrows(PersonShouldBeAdultException.class,()->p2.calculateAge());
    }

    @Test
    @Order(1)
    public void toStringSentenceStartsWithPerson(){
        String sentence = p1.toString();
        assertThat(sentence, startsWith("Person"));
    }


    @Test
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany(){
        Person p3 = new Person(3, "Sandy", "Schillebeeckx", LocalDate.of(1978, 4, 10),mockCompany);
        p3.setGrossSalary(4000);
        when(mockCompany.calculateTaxToPay()).thenReturn(51.0);
        assertEquals(1960,p3.calculateNetSalary(), 0.01);
        verify(mockCompany,times(1)).calculateTaxToPay();
    }

    private LocalDate calculateBoundaryBDforException(){
        return LocalDate.now().minusYears(18).plusDays(1);
    }

}
