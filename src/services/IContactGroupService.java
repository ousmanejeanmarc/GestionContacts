package services;

import java.util.ArrayList;
import java.util.List;

import entities.Contact;
import entities.ContactGroup;

public interface IContactGroupService {
	public ContactGroup createContactGroup(String groupName);
	public boolean save (ContactGroup grp);
	public List<ContactGroup> initialiseGroup();
	public List<ContactGroup> showGroup();
	public void removeGroup(Long idGroup);
	public void updateGroup(Long idGroup, String groupName);
	public boolean removeFromGroup(Contact contact,ContactGroup group);
	public void createContactGroup(ContactGroup group);
	public void update(ContactGroup group2);
}
