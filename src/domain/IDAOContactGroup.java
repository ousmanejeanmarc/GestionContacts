package domain;

import java.util.ArrayList;
import java.util.List;

import entities.Contact;
import entities.ContactGroup;


public interface IDAOContactGroup {

	Boolean createGroup(ContactGroup groupe);

	ContactGroup loadGroup(Long idGroup);
	public List<ContactGroup> initialiseGroup();
}
