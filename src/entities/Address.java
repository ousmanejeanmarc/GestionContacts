package entities;

import java.util.HashMap;

public class Address {
	
	
	private long idAddress;
	private String Street;
	private String City;
	private String Zip;
	private String Country;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Address(String street, String city, String zip, String country) {
		super();
		Street = street;
		City = city;
		Zip = zip;
		Country = country;
	}


	public Address(HashMap<String, String> attributesAddress) {
		// TODO Auto-generated constructor stub
		Street = attributesAddress.get("street");
		City = attributesAddress.get("city");
		Zip = attributesAddress.get("zip");
		Country= attributesAddress.get("country");
	}


	public String getStreet() {
		return Street;
	}


	public void setStreet(String street) {
		Street = street;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getZip() {
		return Zip;
	}


	public void setZip(String zip) {
		Zip = zip;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	public long getId() {
		return idAddress;
	}


	public void setId(long idAddress) {
		this.idAddress = idAddress;
	}


	public void setAttributes(HashMap<String, String> attributesAddress) {
		// TODO Auto-generated method stub
		Street = attributesAddress.get("street");
		City = attributesAddress.get("city");
		Zip = attributesAddress.get("zip");
		Country= attributesAddress.get("country");
		
	}
	
	
	
}
