package services;

import java.util.HashMap;

import domain.DAOAdress;
import domain.IDAOAddress;
import entities.Address;
import entities.Contact;

public class AddressService implements IAddressService{
	
	private IContactService contactService = new ContactService();
	private IDAOAddress daoAddress = new DAOAdress();


	public Address createAddressContact(String street, String city, String zip,
			String country) {
		// TODO Auto-generated method stub
		Address createdAddress = null;	
		Address addr=new Address();
		
		addr.setStreet(street);
		addr.setCity(city);
		addr.setZip(zip);
		addr.setCountry(country);
				
		//appel du DAO
		IDAOAddress daoAddr=new DAOAdress();
		
		//creation de l'addresse
		 createdAddress=daoAddr.createAddress(addr);		 
		return createdAddress;
	}

	public Address getAddressContact(Contact contact) {
		// TODO Auto-generated method stub
		
		return daoAddress.getAddressContact(contact);
		
	}
	public Address getAddressContact(String email) 
	{
		return daoAddress.getAddressContact(email);
	}

	public void updateAddress(Long idContact,
			HashMap<String, String> attributes) {
		// TODO Auto-generated method stub
		Address address = new Address(attributes);
		daoAddress.updateAddress(address);
		
	}
}

