package be.abis.exercise.repository;

import be.abis.exercise.model.Address;

import java.io.IOException;
import java.nio.file.Path;

public class FileAddressRepository implements AddressRepository {

    @Override
    public void saveAddress(Address a, Path pathToFile) throws IOException {
        a.writeToFile(pathToFile);
    }
}
