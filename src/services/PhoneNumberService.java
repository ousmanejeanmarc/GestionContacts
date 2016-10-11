package services;

import domain.DAOPhoneNumber;
import domain.IDAOPhoneNumber;
import entities.Contact;
import entities.PhoneNumber;

public class PhoneNumberService implements IPhoneNumberService{
	
	

	public PhoneNumber creatContactPhoneNumber(String phoneKind, String phoneNumber,Contact contact) {
		// TODO Auto-generated method stub
		
	
		PhoneNumber phone=new PhoneNumber(phoneKind,phoneNumber,contact);
		
		IDAOPhoneNumber daophoneNumber=new DAOPhoneNumber();
		daophoneNumber.createContactPhoneNumber(phone);
		return phone;
	}

	public boolean save(PhoneNumber phone) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
