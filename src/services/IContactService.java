package services;



import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;

public interface IContactService {

	public Contact createContact(String firstName,String lastName,String email,Address idAddress);
	public Entreprise createEntreprise(String firstName,String lastName,String email,Address idAddress,long numSiret);
	public  boolean saveContact(Contact contact);
	public boolean saveEntreprise(Entreprise entrp);
	public void bindContactGroupe(Contact cont,ContactGroup grp);
	public Address getAdd();
}
