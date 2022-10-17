package be.abis.exercise.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Address {
	
	private String street;
	private String nr;
	private String zipCode;
	private String town;
	private String country;
	private String countryCode;
	private final static Path filePath= Paths.get("/temp/javacourses/addresses.txt");

	public Address(String street, String nr, String zipCode, String town, String country, String countryCode) {
		this.street = street;
		this.nr = nr;
		this.zipCode = zipCode;
		this.town = town;
		this.country = country;
		this.countryCode = countryCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public static Path getFilePath() {
		return filePath;
	}

	@Override
	public String toString() {
		return "street='" + street + '\'' +
				", nr='" + nr + '\'' +
				", zipCode='" + zipCode + '\'' +
				", town='" + town + '\'' +
				", country='" + country + '\'' +
				", countryCode='" + countryCode + '\'';
	}

	public boolean isBelgianZipCodeNumeric(){
		boolean isCorrect=false;
		try {
			if (this.getCountryCode().equalsIgnoreCase("BE")) {
				Integer.parseInt(this.zipCode);
				isCorrect = true;
			}
		} catch (NumberFormatException nfe){

		}
		return isCorrect;
	}

	public void writeToFile() throws IOException {
		BufferedWriter bw = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		bw.write(this+"\n");
		bw.close();
	}
}
