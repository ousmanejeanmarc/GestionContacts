package services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import domain.DAOPhoneNumber;
import domain.IDAOPhoneNumber;
import entities.Contact;
import entities.PhoneNumber;

public  class PhoneNumberService implements IPhoneNumberService{
	
	IDAOPhoneNumber daophoneNumber=new DAOPhoneNumber();

	/*public PhoneNumber creatContactPhoneNumber(String phoneKind, String phoneNumber,Contact contact) {
		// TODO Auto-generated method stub
		PhoneNumber phone=new PhoneNumber(phoneKind,phoneNumber,contact);
		daophoneNumber.createContactPhoneNumber(phone);
		return phone;
		
	}*/

	public Boolean creatContactPhoneNumber(HashMap<String, String> list,
			Contact contact) {
		// TODO Auto-generated method stub
		
		
		 daophoneNumber.createContactPhoneNumber(list,contact);
		
		/*Iterator<String> keySetIterator = list.keySet().iterator();

		while(keySetIterator.hasNext()){
			System.out.print("in"+contact.getEmail());
			
		   String key = keySetIterator.next();
		   PhoneNumber phone=new PhoneNumber(key,list.get(key).toString(),contact);
		   daophoneNumber.createContactPhoneNumber(phone);
		}*/
		return true;
	}

	public List<PhoneNumber> getPhoneNumbers(String email) {
		// TODO Auto-generated method stub
		return daophoneNumber.getPhoneNumbers(email);
	}

	
}
