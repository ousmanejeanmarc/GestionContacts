package services;

import domain.DAOPhoneNumber;
import domain.IDAOPhoneNumber;
import entities.PhoneNumber;

public class PhoneNumberService implements IPhoneNumberService{
	
	

	public boolean creatContactPhoneNumber(String phoneKind, String phoneNumber) {
		// TODO Auto-generated method stub
		
		boolean isCreated=false;
		PhoneNumber phone=new PhoneNumber(phoneKind,phoneNumber);
		
		IDAOPhoneNumber daophoneNumber=new DAOPhoneNumber();
		daophoneNumber.createContactPhoneNumber(phone);
		
		if (daophoneNumber!=null){
			isCreated=true;
		}
		return isCreated;
	}

}
