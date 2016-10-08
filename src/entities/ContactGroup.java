package entities;

import java.util.ArrayList;

public class ContactGroup {
	
	
	public ContactGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactGroup(ArrayList<Contact> contacts, String groupName,
			long idContactGroup) {
		super();
		this.contacts = contacts;
		this.groupName = groupName;
		this.idContactGroup = idContactGroup;
	}
	ArrayList<Contact>contacts;
	private String groupName;
	private long idContactGroup;
	
	
	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public long getIdContactGroup() {
		return idContactGroup;
	}
	public void setIdContactGroup(long idContactGroup) {
		this.idContactGroup = idContactGroup;
	}

}
