package entities;

public class PhoneNumber {
	
	private long idPhoneNumber;
	private String phoneKind;
	private String phoneNumber;
	private Contact contact;
	
	
	
	
	
	public PhoneNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhoneNumber(String phoneKind, String phoneNumber,Contact contact) {
		super();
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
		this.contact=contact;
	}
	
	
	public long getId() {
		return idPhoneNumber;
	}
	public void setId(long id) {
		this.idPhoneNumber = id;
	}
	public String getPhoneKind() {
		return phoneKind;
	}
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@Override
	public String toString(){
		return this.getPhoneKind()+" "+this.getPhoneNumber();
	}
}
