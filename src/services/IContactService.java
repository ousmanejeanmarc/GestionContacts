package services;



import java.util.ArrayList;
import java.util.List;

import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.PhoneNumber;

public interface IContactService {

	public Contact createContact(String firstName,String lastName,String email,Address idAddress);
	public Entreprise createEntreprise(String firstName,String lastName,String email,Address idAddress,long numSiret);
	public  boolean saveContact(Contact contact);
	public boolean saveEntreprise(Entreprise entrp);
	public void bindContactGroupe(Contact cont,ContactGroup groupCreated);
	public Address getAdd();
	public ArrayList<Contact>searchContact(String firstName);
	public List<Contact>searchContactBy(String firstName,String lastName,String email,
			String city,String street, String country,String zip
			);//String phoneNumber
	
	public List<Contact> searchContactBy(String firstName,String lastName,String email,
			String city,String street, String country,String zip,long numSiret,String phone
			);
	
	public ArrayList<Contact>searchContact(String firstName,String lastName,String email,Address addr,PhoneNumber phone,ContactGroup group);
	
	
	
}
