package be.abis.exercise.test;

import be.abis.exercise.exception.SalaryTooLowException;
import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.AbisPaymentService;
import be.abis.exercise.service.PaymentService;
import be.abis.exercise.utility.SecurityChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    PaymentService ps = new AbisPaymentService();

    Person person;

    @Spy
    SecurityChecker securityChecker = new SecurityChecker();

    @BeforeEach
    public void setUp(){
        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgium","BE");
        Company c = new Company("Abis",a);
        person = new Person(1, "Sandy", "Schillebeeckx", LocalDate.of(1978, 4, 10),c);
        ps =  new AbisPaymentService();
    }

    @Test
    public void payingSalaryUnder1500ShouldThrowException() throws SalaryTooLowException {
        person.setGrossSalary(2000.0);
        assertThrows(SalaryTooLowException.class,()->ps.paySalary(person));
    }

    @Test
    public void payingSalaryToJohnWritesSomething() throws SalaryTooLowException {
        person.setGrossSalary(4000);
        ps.paySalary(person);
        //verify(securityChecker,atLeastOnce()).isAbisEmployee(person);
    }


}