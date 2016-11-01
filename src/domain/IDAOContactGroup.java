package domain;

import java.util.ArrayList;
import java.util.List;

import entities.Contact;
import entities.ContactGroup;


public interface IDAOContactGroup {

	Boolean createGroup(ContactGroup groupe);

	ContactGroup loadGroup(Long idGroup);
	public List<ContactGroup> initialiseGroup();

	void deleteGroup(Long idGroup);

	public List<ContactGroup> showGroup();

	void update(Long group,String groupName);

	boolean removeContact(Contact contact, ContactGroup group);

	void update(ContactGroup group);

}
