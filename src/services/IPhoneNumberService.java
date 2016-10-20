package services;

import java.util.HashMap;

import entities.Contact;
import entities.PhoneNumber;

public interface IPhoneNumberService {
	
	//public PhoneNumber creatContactPhoneNumber(String phoneKind, String phoneNumber,Contact contact);
	public Boolean creatContactPhoneNumber(HashMap<String, String> list,Contact contact);
	
}
