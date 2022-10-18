package be.abis.exercise.service;


import be.abis.exercise.exception.SalaryTooLowException;
import be.abis.exercise.model.Person;
import be.abis.exercise.utility.SecurityChecker;

public class AbisPaymentService implements PaymentService{

    SecurityChecker sc=new SecurityChecker();

    public void paySalary(Person person) throws SalaryTooLowException {
        if (sc.isAbisEmployee(person)) {
            double salary = person.calculateNetSalary();
            System.out.println("Paying " + salary + " euros to " + person.getFirstName());
        }
    }
}
