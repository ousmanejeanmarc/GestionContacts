package services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import domain.DAOAdress;
import domain.DAOContact;
import domain.DAOContactGroup;
import domain.DAOPhoneNumber;
import domain.IDAOAddress;
import domain.IDAOContact;
import domain.IDAOContactGroup;
import domain.IDAOPhoneNumber;
import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.PhoneNumber;

public class ContactService implements IContactService{
	
	
	private IDAOAddress daoAddress = new DAOAdress();
	private IDAOPhoneNumber daoPhoneNumber = new DAOPhoneNumber();
	 private  IDAOContact daoContact=new DAOContact();
	 private IDAOContactGroup daoGroup = new DAOContactGroup();
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
	public boolean removeContacts(String[] idContacts) {
		// TODO Auto-generated method stub		
		
		for(String contactS: idContacts)
		{
			Long contactId = Long.parseLong(contactS);
			System.out.println(contactId);
			if(daoContact.deleteContact(contactId))
				return false;
			
		}
		
		return true;
	}
	public  Contact loadContact(Long idContact)
	{
		
		return  daoContact.findContactById(idContact);	

		
	}
	public  Entreprise loadEntreprise(Long idEntreprise) {
		// TODO Auto-generated method stub
		return  daoContact.loadEntreprise(idEntreprise);

		
	}
	
	public  Address getAddressOfContact(Contact contact)
	{
		return null;
	}

	public void updateContact(HashMap<String, String> attributes) {
		// TODO Auto-generated method stub
		
		Long idContact = Long.parseLong(attributes.get("idContact"));	
		//chargement contact
		

		String email = attributes.get("email");
		/* Mise à jour de l'addresse*/	
		Address addressContact = daoAddress.getAddressContact(email);

		addressContact.setAttributes(attributes);
		daoAddress.updateAddress(addressContact);
		
		/*Mise à jour phoneNumbers*/
		List<PhoneNumber>phones = (List<PhoneNumber>) daoPhoneNumber.getPhoneNumbers(email);
		
		TreeMap<String,String>attributesSorted = new TreeMap<String, String>();
		attributesSorted.putAll(attributes);
		SortedMap<String, String> phonesAttrs = attributesSorted.subMap("phone0", "phonez");
		
		System.out.println("les phones "+phonesAttrs);
		/*parcours betes du tableau*/
		int i=0 ,j = 0;
		PhoneNumber phone = null ;
		
		for(Map.Entry<String, String>phoneAtt : phonesAttrs.entrySet())
		{
			try {
					phone=(PhoneNumber) phones.get(i);
					if(j%2 == 0){
						 phone.setPhoneKind(phoneAtt.getValue());//PhoneKind pair
					}
					else{
						//
						phone.setPhoneNumber(phoneAtt.getValue());//PhoneKind impair
						daoPhoneNumber.updateNumber(phone);
						i++;//Numero Suivant
					}
					
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			j++;
		}	
		
		/*Contact*/	
		Contact contact = daoContact.loadContact(idContact);
		if(contact == null)//la session est expirée
		{
			contact = daoContact.findContactById(idContact);
		}		

		daoContact.updateContact(contact,attributes,addressContact,phones);
		
	}
	
	
	
	
	
	
}
