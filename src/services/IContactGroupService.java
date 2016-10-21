package services;

import java.util.ArrayList;
import java.util.List;

import entities.ContactGroup;

public interface IContactGroupService {
	public ContactGroup createContactGroup(String groupName);
	public boolean save (ContactGroup grp);
	public List<ContactGroup> initialiseGroup();
	public List<ContactGroup> showGroup();
}
