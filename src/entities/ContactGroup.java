package entities;

import java.util.HashSet;
import java.util.Set;

public class ContactGroup {
	
	Set<Contact>contacts=new HashSet<Contact>();
	private String groupName;
	private long idContactGroup;
	
	
	public ContactGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactGroup( String groupName,
			long idContactGroup) {
		super();
		this.groupName = groupName;
		this.idContactGroup = idContactGroup;
		
	}
	
	
	
	
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
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
	
	public void addContact(Set<Contact> ct){
		
		this.contacts.addAll(ct);
	}

}
