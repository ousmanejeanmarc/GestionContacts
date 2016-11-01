package services;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;

import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.PhoneNumber;

public interface IContactService {

	public Contact createContact(String firstName,String lastName,String email,Address idAddress);
	
	public  boolean saveContact(Contact contact);
	
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
	public boolean removeContacts(String idContact);
	public void updateContact(HashMap<String, String> attributes);
	
	public Contact loadContact(Long idContact);
	public void createContact(Contact contact1);
	public  void  updateElements(Contact contact,HashMap<String, String> attributes);

	
	public List<Contact>getAllContact();
	/**INTEGRATION OUSMANE**/
	public SortedMap<String, String> bindGroupe(HttpServletRequest request,
			Contact contactCreated);
	
	
	
	
	
}
