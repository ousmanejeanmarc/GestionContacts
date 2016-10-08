package services;

import entities.Address;

public interface IAddressService {
	
	public Address createAddressContact(String street,String city,String zip,String country);

}
