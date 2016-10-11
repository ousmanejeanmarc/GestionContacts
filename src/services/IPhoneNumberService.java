package services;

import entities.Contact;
import entities.PhoneNumber;

public interface IPhoneNumberService {
	
	public PhoneNumber creatContactPhoneNumber(String phoneKind, String phoneNumber,Contact contact);
	
}
