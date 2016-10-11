package services;


import java.util.HashSet;
import java.util.Set;

import domain.DAOContact;
import domain.IDAOContact;
import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;

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
	 * ousmane 
	 * @param cont
	 * @param grp
	 */
	public void bindContactGroupe(Contact cont,ContactGroup grp){
	
		 Set<ContactGroup> group=new HashSet<ContactGroup>();
		 Set<Contact> ct=new HashSet<Contact>();
		 
		 ct.add(cont);
		 group.add(grp);
		 
		 cont.addGroup(group);
		 grp.addContact(ct);
	}
}
