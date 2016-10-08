package services;

import entities.Address;

public interface IContactService {

	public boolean createContact(String firstName,String lastName,String email,Address idAddress);
	public Address getAdd();
}
