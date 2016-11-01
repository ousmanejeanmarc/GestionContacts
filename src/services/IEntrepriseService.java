package services;



import java.util.List;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;

import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;


public interface IEntrepriseService {
	public Entreprise createEntreprise(String firstName,String lastName,String email,Address idAddress,long numSiret);
		public boolean saveEntreprise(Entreprise entrp);
	public void bindContactGroupe(Entreprise cont,ContactGroup groupCreated);
	
	public Entreprise loadEntreprise(Long idContact);
		public Entreprise loadEntrepriseW(Long entrepriseId);
	
	public List<Entreprise> getAllEntreprise();
	/**INTEGRATION OUSMANE**/
	public SortedMap<String, String> bindGroupe(HttpServletRequest request,
			Entreprise contactCreated);
	public List<Entreprise> searchEntrepriseBy(String numSiret,String firstName,String lastName,String email,
			String city,String street, String country,String zip);
	

	
	
	
	
}
