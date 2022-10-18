package be.abis.exercise.test;

import be.abis.exercise.model.Address;
import be.abis.exercise.repository.AddressRepository;
import be.abis.exercise.repository.FileAddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileAddressRepositoryTest {

    AddressRepository addressRepository;

    @Mock
    Address address;

    @BeforeEach
    public void setUp(){
        addressRepository = new FileAddressRepository();
    }

    @Test
    public void repoSavesAddressCorrectly() throws IOException {
        doNothing().when(address).writeToFile(any(Path.class));
        addressRepository.saveAddress(address, Paths.get("somefile1.txt"));
        verify(address).writeToFile(any(Path.class));
    }

    @Test
    public void repoSavesAddressCorrectlyWithAnswer() throws IOException {
        /*Answer myAnswer = new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Path p = invocation.getArgument(0);
                System.out.println("The address was saved to " + p);
                return null;
            }
        };*/
        Answer myAnswer =
                invocation -> {System.out.println("The address was saved to " + invocation.getArgument(0));return null;};
        doAnswer(myAnswer).when(address).writeToFile(any(Path.class));
        addressRepository.saveAddress(address, Paths.get("somefile2.txt"));
        verify(address).writeToFile(any(Path.class));
    }

    @Test
    public void repoThrowsIOExceptionWhileSaving() throws IOException {
        doThrow(IOException.class).when(address).writeToFile(any(Path.class));
        assertThrows(IOException.class, () ->  addressRepository.saveAddress(address,Paths.get("somefile.txt")));
    }

    @Test
    public void repoSavesAddressCorrectlyUseCaptor() throws IOException {
        Path path = Paths.get("somefile3.txt");
        ArgumentCaptor<Path> pathCaptor = ArgumentCaptor.forClass(Path.class);
        addressRepository.saveAddress(address,path);
        verify(address).writeToFile(pathCaptor.capture());
        Path usedPath= pathCaptor.getValue();
        assertEquals("somefile3.txt",usedPath.getFileName().toString());

    }



}