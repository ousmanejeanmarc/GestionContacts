package services;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import domain.DAOAdress;
import domain.DAOContactGroup;
import domain.DAOEntreprise;
import domain.DAOPhoneNumber;
import domain.IDAOAddress;
import domain.IDAOContactGroup;
import domain.IDAOEntreprise;
import domain.IDAOPhoneNumber;
import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.PhoneNumber;

public class EntrepriseService  implements IEntrepriseService{
	
	private IDAOAddress daoAddress = new DAOAdress();
 	private IDAOPhoneNumber daoPhoneNumber = new DAOPhoneNumber();
    private  IDAOEntreprise daoEntreprise=new DAOEntreprise();	
    private IDAOContactGroup daoGroup = new DAOContactGroup();

	 /**
	 * 
	 */

	public Entreprise createEntreprise(String firstName, String lastName, String email,Address idAddress,long numSiret) {
		// TODO Auto-generated method stub
		
		Entreprise ent=new Entreprise();
		
		ent.setFirstName(firstName);
		ent.setLastName(lastName);
		ent.setEmail(email);
		ent.setAddress(idAddress);
		ent.setNumSiret(numSiret);
		return ent;
	}
	
	/**
	 * ousmane 
	 * @param cont
	 * @param grp
	 */
	public void bindContactGroupe(Entreprise ent,ContactGroup grp){
	
	
		 ent.addGroup(grp);
		 grp.addContact(ent);
		 
	}
	
	public boolean saveEntreprise(Entreprise entrp){
		
		Entreprise entrprise= daoEntreprise.createEntreprise(entrp);
		
		if(entrprise!=null){
			return true;
		}
		return false;
	}

	public  Entreprise loadEntreprise(Long idEntreprise) {
		// TODO Auto-generated method stub
		return  daoEntreprise.loadEntreprise(idEntreprise);

		
	}
	
	
	public Entreprise loadEntrepriseW(Long entrepriseId) {
		// TODO Auto-generated method stub
		Entreprise entreprise =daoEntreprise.findEntrepriseById(entrepriseId);
		daoEntreprise.fetchInfo((Contact)entreprise);
		return entreprise;
	}
	public SortedMap<String, String> bindGroupe(HttpServletRequest request,
			Entreprise entrepriseCreated) {
	
		
		Enumeration<String> parametersName= request.getParameterNames();
		String parameterName= null;
		HashMap<String, String>params=new HashMap<String, String>();
		try {
			while((parameterName=parametersName.nextElement())!=null){
				params.put(parameterName, request.getParameter(parameterName));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TreeMap<String, String>valeur=new TreeMap<String, String>();
		valeur.putAll(params);
		SortedMap<String, String> group =new TreeMap<String, String>() ;
		
		group=valeur.subMap("groupes0", "groupesz");
		
		
		
		for(Map.Entry<String, String>groupAtt : group.entrySet())
		{
			Long id = Long.parseLong(groupAtt.getValue());

			ContactGroup groupe = daoGroup.loadGroup(id);
			entrepriseCreated.addGroup(groupe);
		}
		return group;
	}

	public List<Entreprise> getAllEntreprise() {
		// TODO Auto-generated method stub
		return daoEntreprise.getAllEntreprise();
	}

	public List<Entreprise> searchEntrepriseBy(String numSiret, String firstName,
			String lastName, String email, String city, String street,
			String country, String zip) {
		// TODO Auto-generated method stub
		System.out.println("iam in the szervices");
			return daoEntreprise.searchEntrepriseBy(numSiret, firstName,lastName,email,city,street,country,zip);
	

	}
	


}
