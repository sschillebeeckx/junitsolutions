package be.abis.exercise.service;

import be.abis.exercise.exception.SalaryTooLowException;
import be.abis.exercise.model.Person;
import be.abis.exercise.utility.SecurityChecker;

public interface PaymentService {

    void paySalary(Person person) throws SalaryTooLowException;
    void setSc(SecurityChecker sc);
}
