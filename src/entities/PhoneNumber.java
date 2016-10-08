package entities;

public class PhoneNumber {
	
	private long idPhoneNumber;
	private String phoneKind;
	private String phoneNumber;
	
	
	public PhoneNumber(String phoneKind, String phoneNumber) {
		super();
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneNumber() {
		super();
		// TODO Auto-generated constructor stub
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


}
