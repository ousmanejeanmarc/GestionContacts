package domain;

import java.util.HashMap;
import java.util.List;

import entities.Address;
import entities.Contact;
import entities.Entreprise;
import entities.PhoneNumber;

public interface IDAOEntreprise {

	List<Entreprise> getAllEntreprise();
	void fetchInfo(Contact entreprise);
	Entreprise loadEntreprise(Long idEntreprise);
	Entreprise createEntreprise(Entreprise entrp);
	Entreprise findEntrepriseById(Long entrepriseId);
	public void updateEntreprise(Entreprise entreprise,
			HashMap<String, String> attributes, Address addressContact,
			List<PhoneNumber> phones);
	List<Entreprise> searchEntrepriseBy(String numSiret, String firstName, String lastName,
			String email, String city, String street, String country, String zip);

}
