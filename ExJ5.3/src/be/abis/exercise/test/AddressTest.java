package be.abis.exercise.test;

import be.abis.exercise.model.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class AddressTest {

    @Test
    public void belgianZipCodeShouldBeNumeric() {
        //arrange
        Address a = new Address("Diestsevest", "32 bus 4B", "3000", "Leuven", "Belgium", "BE");

        //act
        boolean b = a.isBelgianZipCodeNumeric();

        //assert
        assertTrue(b);
    }


}
