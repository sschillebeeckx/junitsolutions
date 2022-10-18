package be.abis.exercise.test;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CompanyTest {

    @Mock
    Address a;

    @Test
    public void taxForBelgianCompanyShouldBe51() {
        //arrange
        Company c = new Company("ABIS",a);
        when(a.getCountryCode()).thenReturn("BE");
        //act
        double taxToPay = c.calculateTaxToPay();

        //assert
        assertEquals(51.00,taxToPay,0.0001);

        verify(a,atLeastOnce()).getCountryCode();
    }

}
