package be.abis.demomock.model;

public class Person {

    private String firstName;
    private int heightInCentimeters;

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName, int heightInCentimeters) {
        this(firstName);
        this.heightInCentimeters = heightInCentimeters;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getHeightInCentimeters() {
        return heightInCentimeters;
    }

    public void setHeightInCentimeters(int heightInCentimeters) {
        this.heightInCentimeters = heightInCentimeters;
    }

    public double calculateHeightInInches(){
        double heightInInches = 0.3937*heightInCentimeters;
        return heightInInches;
    }
}
