package services;

import entities.Address;
import entities.Contact;

public interface IAddressService {
	
	public Address createAddressContact(String street,String city,String zip,String country);

	public Address getAddressContact(Contact contact);
	

}
