package domain;

import java.util.ArrayList;
import java.util.List;

import entities.Contact;
import entities.Entreprise;

public interface IDAOContact {
	
	
	public Contact createContact(Contact contact);
	public Entreprise createEntreprise(Entreprise entrp);
	public boolean deleteContact(Contact contact);
	public Contact updateContact(Contact contact);
	
	public ArrayList<Contact>searchContactByFirstName(String firstName);
	
	public List<Contact> searchContactByEntreprise(String firstName,String lastName,String email,
			String city,String street, String country, String zip,long numSiret,String phone);	

}
