package be.abis.demomock.service;

import be.abis.demomock.exception.NotBigEnoughException;
import be.abis.demomock.model.Person;

public interface HelloService {

    String getHelloMessage();
    Person findPerson(int id);
    void sayHelloTo(Person person) throws NotBigEnoughException;

}
