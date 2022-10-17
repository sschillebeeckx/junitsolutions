package be.abis.exercise.service;


import be.abis.exercise.exception.SalaryTooLowException;
import be.abis.exercise.model.Person;

public class AbisPaymentService implements PaymentService{

    public void paySalary(Person person) throws SalaryTooLowException {
        double salary =  salary = person.calculateNetSalary();
        System.out.println("Paying " + salary + " euros to " + person.getFirstName());
    }
}
