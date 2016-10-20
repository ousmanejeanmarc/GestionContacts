package services;

import domain.DAOAdress;
import domain.IDAOAddress;
import entities.Address;

public class AddressService implements IAddressService{
	

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
}
