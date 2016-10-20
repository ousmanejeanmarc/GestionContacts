package services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.DAOContact;
import domain.IDAOContact;
import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.GROUPNAME;
import entities.PhoneNumber;

public class ContactService implements IContactService{
	
	
	IDAOContact daoContact=new DAOContact();
	/**
	 * 
	 */
	public Contact createContact(String firstName, String lastName, String email,Address idAddress) {
		// TODO Auto-generated method stub
		boolean isCreated=false;

		Contact contact=new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		contact.setAddress(idAddress);
		return contact;
	}
	public Entreprise createEntreprise(String firstName, String lastName, String email,Address idAddress,long numSiret) {
		// TODO Auto-generated method stub
		
		Entreprise ent=new Entreprise();
		
		ent.setFirstName(firstName);
		ent.setLastName(lastName);
		ent.setEmail(email);
		ent.setAddress(idAddress);
		ent.setNumSiret(numSiret);
		return ent;
	}
	
	/**
	 * ousmane 
	 * @param cont
	 * @param grp
	 */
	public void bindContactGroupe(Contact cont,ContactGroup grp){
	
	
		 cont.addGroup(grp);
		 grp.addContact(cont);
		 
	}
	/**
	 * 
	 */
	
	public boolean saveContact(Contact contact){
		
		//faire appel du dao

			Contact contactCreated=daoContact.createContact(contact);

		if(contact!=null){
			return true;
		}
		return false;
	}
public boolean saveEntreprise(Entreprise entrp){
		
		//faire appel du dao
		
			Entreprise entrprise= daoContact.createEntreprise(entrp);
		
		if(entrprise!=null){
			return true;
		}
		return false;
	}
	public Address getAdd() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	
	/**
	 * search contact by firstname only
	 */
	public ArrayList<Contact> searchContact(String firstName) {
		// TODO Auto-generated method stub
		DAOContact searchConact=new DAOContact();
		return searchConact.searchContactByFirstName(firstName);
	}
	
	/**
	 * search contact by first last email
	 */
	public List<Contact> searchContactBy(String firstName,String lastName,String email,String city,
			String street,String country,String zip, long numSiret,String phone) {
		// TODO Auto-generated method stub
		DAOContact searchConact=new DAOContact();
		//return searchConact.searchContactBy(firstName,lastName,email,city,street,country,zip);
		return searchConact.searchContactByEntreprise(firstName,lastName,email,city,street,country,zip,numSiret,phone);
	}
	
	
	public ArrayList<Contact> searchContact(String firstName, String lastName,
			String email, Address addr, PhoneNumber phone, ContactGroup group) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Contact> searchContactBy(String firstName, String lastName,
			String email, String city, String street, String country, String zip) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
}
