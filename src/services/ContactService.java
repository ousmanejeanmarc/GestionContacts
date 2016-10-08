package services;

import domain.DAOContact;
import domain.IDAOContact;
import entities.Address;
import entities.Contact;

public class ContactService implements IContactService{
	
	
	public boolean createContact(String firstName, String lastName, String email,Address idAddress) {
		// TODO Auto-generated method stub
		boolean isCreated=false;

		Contact contact=new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		contact.setIdAddress(idAddress);
		
		//faire appel du dao
		IDAOContact daoContact=new DAOContact();
		
		//creer le contact
		Contact contactCreated=daoContact.createContact(contact);
		
		if(contactCreated!=null){
			isCreated=true;
		}
		return isCreated;
	}

	public Address getAdd() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	

	
	

	

}
