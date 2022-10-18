package be.abis.exercise.test;

import be.abis.exercise.exception.SalaryTooLowException;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.AbisPaymentService;
import be.abis.exercise.service.PaymentService;
import be.abis.exercise.utility.SecurityChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @InjectMocks
    PaymentService ps = new AbisPaymentService();

    @Mock Person person;
    @Mock SecurityChecker securityChecker;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void payingSalaryUnder1500ShouldThrowException() throws SalaryTooLowException {
        when(securityChecker.isAbisEmployee(any(Person.class))).thenReturn(true);
        when(person.calculateNetSalary()).thenThrow(SalaryTooLowException.class);
        assertThrows(SalaryTooLowException.class,()->ps.paySalary(person));
    }

    @Test
    public void payingSalaryToJohnWritesSomething() throws SalaryTooLowException {
        when(securityChecker.isAbisEmployee(person)).thenReturn(true);
        when(person.calculateNetSalary()).thenReturn(2000.00);
        when(person.getFirstName()).thenReturn("John");
        ps.paySalary(person);
    }

    @Test
    public void canYouMockTheStaticMethod(){
        try (MockedStatic theMock  = mockStatic(SecurityChecker.class)) {
            theMock.when(()->SecurityChecker.encryptPassword(any(String.class))).thenReturn("guess");
            assertEquals("guess",ps.findEncryptedPassword("blabla"));
        }

    }

}