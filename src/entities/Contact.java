package entities;

public class Contact {
	
	
	
	public Contact(long idaddr) {
		super();
		
	}
	private String firstName;
	private String lastName;
	private String email;
	private long idContact;
	private  Address idAddress;
		


	

	public Address getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Address idAddress) {
		this.idAddress = idAddress;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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
	
	

}
