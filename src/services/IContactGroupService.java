package services;

import entities.ContactGroup;

public interface IContactGroupService {
	public ContactGroup createContactGroup(String groupName);
	public boolean save (ContactGroup group);
}
