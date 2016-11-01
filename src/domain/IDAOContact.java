package domain;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import entities.Address;
import entities.Contact;
import entities.Entreprise;
import entities.PhoneNumber;

public interface IDAOContact {
	
	public Contact createContact(Contact contact);
	
	public boolean deleteContact(Long contact);
	
	public Contact loadContact(Long idContact);
	public Contact findContactById(Long idContact);
	public void updateContact(Contact contact);
	public List<Contact> searchContactBy(String firstName, String lastName,
			String email, String city, String street, String country, String zip);
	public  List<Contact> getAllContact();	

}
