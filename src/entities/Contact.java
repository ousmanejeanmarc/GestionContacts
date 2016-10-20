package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

public class Contact {

	private String firstName;
	private String lastName;
	private String email;
	private long idContact;
	private Address  address;
	private Set<PhoneNumber> phoneNumber= new HashSet<PhoneNumber>();
	
	public Set<PhoneNumber> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Set<PhoneNumber> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	private Set<ContactGroup>group=new HashSet<ContactGroup>(); 
	private int version;
	
	
	
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
		
	public Address getAddress() {return address;}
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
	public void addGroup(ContactGroup grp)
	{
		
			this.group.add(grp);
	
	}
	public void addPhoneNumber(Set<PhoneNumber> phones){
		this.phoneNumber.addAll(phones);
	}

}
