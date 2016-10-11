package domain;

import entities.Contact;
import entities.Entreprise;

public interface IDAOContact {
	
	
	public Contact createContact(Contact contact);
	public Entreprise createEntreprise(Entreprise entrp);
	public boolean deleteContact(Contact contact);
	public Contact updateContact(Contact contact);
	

}
