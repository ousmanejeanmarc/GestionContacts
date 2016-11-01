package entities;

import java.util.HashSet;
import java.util.Set;

public class Contact {

	protected String firstName;
	protected String lastName;
	protected String email;
	protected long idContact;
	protected Address  address;
	protected Set<PhoneNumber> phoneNumbers=new HashSet<PhoneNumber>();
	protected Set<ContactGroup>group=new HashSet<ContactGroup>();
	protected int version;

	public Contact() {super();}
	
	public Contact(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;	
		
	}
	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public String getEmail() {return email;}	
	public void setEmail(String email) {this.email = email;}
	public long getId() {return idContact;}
	public void setId(long id) {this.idContact = id;}
	public Set<PhoneNumber> getPhoneNumbers() {return phoneNumbers;}
	public void setPhoneNumbers(Set<PhoneNumber> phoneNumber) {
		phoneNumber=new HashSet<PhoneNumber>();
		this.phoneNumbers = phoneNumber;
	}
	public Address getAddress() {
		
		return address;}
	public void setAddress(Address address) {this.address = address;}

	/**
	 * @return the group
	 */
	public Set<ContactGroup> getGroup() {
		return group;
	}
	

	/**
	 * @param group the group to set
	 */
	public void setGroup(Set<ContactGroup> group) {
		this.group = group;
	}
	public void addGroup(Set<ContactGroup> grp)
	{
		
			this.group.addAll(grp);
	
	}

	public void addGroup(ContactGroup grp) {
		// TODO Auto-generated method stub
		this.group.add(grp);
		
	}

}
