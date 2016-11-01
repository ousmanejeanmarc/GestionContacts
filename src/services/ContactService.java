package services;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
/*	private  IDAOContact daoContact;
	private IDAOAddress daoAddress;
	*/
	
//	 ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	 
private IDAOAddress daoAddress = new DAOAdress();
 	private IDAOPhoneNumber daoPhoneNumber = new DAOPhoneNumber();
	 private  IDAOContact daoContact=new DAOContact();	
   private IDAOContactGroup daoGroup = new DAOContactGroup();
 

	/*** SPring**/
//	 private  IDAOContact daoContact=(IDAOContact) context.getBean("BeanContact");
//	private IDAOContactGroup daoGroup = (IDAOContactGroup) context.getBean("BeanGroup");	
//	 private IDAOAddress daoAddress = (IDAOAddress) context.getBean("BeanAddress");
//	 private IDAOPhoneNumber daoPhoneNumber = (IDAOPhoneNumber) context.getBean("BeanPhone");
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
		return searchConact.searchContactBy(firstName,lastName,email,city,street,country,zip);
		//return searchConact.searchContactByEntreprise(firstName,lastName,email,city,street,country,zip,numSiret,phone);
	}
	
	
	public ArrayList<Contact> searchContact(String firstName, String lastName,
			String email, Address addr, PhoneNumber phone, ContactGroup group) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * search contact by first last email
	 */
	public List<Contact> searchContactBy(String firstName,String lastName,String email,String city,
			String street,String country,String zip) {
		// TODO Auto-generated method stub
		//DAOContact searchConact=new DAOContact();
		return daoContact.searchContactBy(firstName,lastName,email,city,street,country,zip);
	}

	public boolean removeContacts(String idContact) {
		// TODO Auto-generated method stub		
		

			Long contactId = Long.parseLong(idContact);
			//System.out.println(contactId);
			if(daoContact.deleteContact(contactId))
				return false;
			
		return true;
	}
	public  Contact loadContact(Long idContact)
	{
		
		return  daoContact.loadContact(idContact);	

		
	}
	
	
	public  void  updateElements(Contact contact,HashMap<String, String> attributes)
	{
		
		
		
		Address addressContact = daoAddress.getAddressContact(contact.getEmail());
		addressContact.setAttributes(attributes);
		daoAddress.updateAddress(addressContact);
		
		String email = attributes.get("email");

		
		/*Mise à jour phoneNumbers*/
		List<PhoneNumber>phones = (List<PhoneNumber>) daoPhoneNumber.getPhoneNumbers(email);
		
		TreeMap<String,String>attributesSorted = new TreeMap<String, String>();
		attributesSorted.putAll(attributes);
		
		SortedMap<String, String> phonesAttrs = attributesSorted.subMap("phone0", "phonez");
		
		/*parcours betes du tableau*/
		//int i=0 ,j = 0;
		PhoneNumber phone = null ;
		int i = 0;
		
		for(Map.Entry<String, String>phoneAtt : phonesAttrs.entrySet())
		{
			
			phone = phones.get(i);
			phone.setPhoneNumber(phoneAtt.getValue());
			phone.setPhoneKind(attributes.get(phoneAtt.getValue()));
			daoPhoneNumber.updateNumber(phone);
			i++;
		}	
		
	}

	public void updateContact(HashMap<String, String> attributes) {
		// TODO Auto-generated method stub
		
		Long idContact = Long.parseLong(attributes.get("idContact"));	

		
		//chargement du contact
		Contact contact = daoContact.loadContact(idContact);
			
		//Mise à jour  du graphe
		this.updateElements(contact, attributes);
		
		/*save Contact*/	
		contact.setAttributes(attributes);
		daoContact.updateContact(contact);
		
		
	}
	public void createContact(Contact contact) {
		// TODO Auto-generated method stub
		daoContact.createContact(contact);
	}
	public Contact loadContactW(Long idContact) {
		// TODO Auto-generated method stub
		Contact contact = daoContact.findContactById(idContact);
		//daoContact.fetchInfo(contact);
		return contact;
	}
	
	public SortedMap<String, String> bindGroupe(HttpServletRequest request,
			Contact contactCreated) {
	
		
		Enumeration<String> parametersName= request.getParameterNames();
		String parameterName= null;
		HashMap<String, String>params=new HashMap<String, String>();
		try {
			while((parameterName=parametersName.nextElement())!=null){
				params.put(parameterName, request.getParameter(parameterName));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TreeMap<String, String>valeur=new TreeMap<String, String>();
		valeur.putAll(params);
		SortedMap<String, String> group =new TreeMap<String, String>() ;
		
		group=valeur.subMap("groupes0", "groupesz");
		
		//saveContact(contactCreated);
		
		for(Map.Entry<String, String>groupAtt : group.entrySet())
		{
			Long id = Long.parseLong(groupAtt.getValue());

			ContactGroup groupe = daoGroup.loadGroup(id);
			
		System.out.println("group------>"+groupe.getGroupName());
			//bindContactGroupe(contactCreated, groupe);
			contactCreated.addGroup(groupe);
			//groupe.addContact(contactCreated);
			
		}
		//	
		
		return group;
	}
	public List<Contact> getAllContact() {
		// TODO Auto-generated method stub
		return daoContact.getAllContact();
	}
	
	
}
