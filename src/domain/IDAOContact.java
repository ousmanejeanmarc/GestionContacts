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
	public Entreprise createEntreprise(Entreprise entrp);	
	//public void updateContact(Contact contact, HashMap<String, String> attributes, Address addressContact, List<PhoneNumber> phones);	
	public boolean deleteContact(Long contact);
	public Entreprise loadEntreprise(Long idEntreprise);
	public Contact loadContact(Long idContact);
	public Contact findContactById(Long idContact);
	public void updateContact(Contact contact,
			HashMap<String, String> attributes, Address addressContact,
			List<PhoneNumber> phones);
	

}
