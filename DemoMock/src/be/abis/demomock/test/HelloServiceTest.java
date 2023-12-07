package be.abis.demomock.test;

import be.abis.demomock.exception.NotBigEnoughException;
import be.abis.demomock.model.Person;
import be.abis.demomock.service.AbisHelloService;
import be.abis.demomock.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HelloServiceTest {

    private HelloService helloService = new AbisHelloService();

    @Mock
    private Person mockPerson;

    @Test
    void sayHelloToJohn() throws NotBigEnoughException {
        when(mockPerson.calculateHeightInInches()).thenReturn(70.0);
        when(mockPerson.getFirstName()).thenReturn("John");
        helloService.sayHelloTo(mockPerson);
    }

    @Test
    void sayHelloToAnnThrowsException(){
        when(mockPerson.calculateHeightInInches()).thenReturn(62.9);
        assertThrows(NotBigEnoughException.class, ()-> {helloService.sayHelloTo(mockPerson);});
    }
}
