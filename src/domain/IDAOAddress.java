package domain;

import entities.Address;
import entities.Contact;

public interface IDAOAddress {

	
	public Address createAddress(Address address);

	public boolean updateAddress(Address address);

	public Address getAddressContact(String email);

	public Address getAddressContact(Contact contact);
}
