package be.abis.exercise.model;

public class Company {
	
	private String name;
	private Address address;
	
	public Company(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double calculateTaxToPay(){
		double taxToPay = 0.0;
		switch(address.getCountryCode()){
			case "BE"  : taxToPay = 51.0; break;
			case "NL" : taxToPay = 47.0; break;
			default : taxToPay = 35.0; break;
		}
		return taxToPay;
	}
	
	

}
