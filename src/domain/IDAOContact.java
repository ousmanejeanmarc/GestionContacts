package domain;

import entities.Contact;

public interface IDAOContact {
	
	
	public Contact createContact(Contact contact);
	public boolean deleteContact(Contact contact);
	public Contact updateContact(Contact contact);
	

}
