package domain;

import java.util.HashMap;
import java.util.List;

import entities.Contact;
import entities.PhoneNumber;

public interface IDAOPhoneNumber {
	
	//public PhoneNumber createContactPhoneNumber(PhoneNumber phone);
	public Boolean createContactPhoneNumber(HashMap<String, String>list, Contact ct);

	public List<PhoneNumber> getPhoneNumbers(String email);

	public void updateNumber(PhoneNumber phone);

}
