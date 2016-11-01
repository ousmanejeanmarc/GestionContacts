package domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.PhoneNumber;

public class DAOEntreprise implements IDAOEntreprise {
	

	public List<Entreprise> getAllEntreprise() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
		Transaction transaction = session.beginTransaction();	
		List<Entreprise> entreprises = session.createQuery(" from Contact as contact where contact.class=Entreprise order by contact.firstName ASC ").list();
	
		transaction.commit();	

		return entreprises;
	}

	public void fetchInfo(Contact contact) {
		// TODO Auto-generated method stub
		if(!Hibernate.isInitialized(contact))//pas necessaire
			return;
		Hibernate.initialize(contact.getPhoneNumbers());
		for(PhoneNumber phone: contact.getPhoneNumbers())
			Hibernate.initialize(phone);
		Hibernate.initialize(contact.getGroup());
		for(ContactGroup groupe: contact.getGroup())
			Hibernate.initialize(groupe);
	}

	public Entreprise loadEntreprise(Long idEntreprise) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();	
		Entreprise entreprise = (Entreprise)session.load(Entreprise.class, idEntreprise);
		transaction.commit();
		return entreprise;
	}

	public Entreprise createEntreprise(Entreprise entrp){
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(entrp);
			transaction.commit();
						
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
		}	
		return entrp;
	}


  public Entreprise findEntrepriseById(Long entrepriseId) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();		
		Entreprise entreprise = (Entreprise) session.load(Entreprise.class, entrepriseId);	
		transaction.commit();
		return entreprise;
	}

  public void updateEntreprise(Entreprise entreprise,
			HashMap<String, String> attributes, Address addressContact,
			List<PhoneNumber> phones) {
		// TODO Auto-generated method stub
		//updateContact((Contact)entreprise, attributes, addressContact, phones);
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		entreprise.setEmail(attributes.get("email"));
		entreprise.setFirstName(attributes.get("firstName"));
		entreprise.setLastName(attributes.get("lastName"));
		//Mise à jour pour maintenance bidirectionnelle
		entreprise.setAddress(addressContact);		
		entreprise.setPhoneNumbers(new HashSet<PhoneNumber>(phones));	
		
		Long numSiret = Long.parseLong(attributes.get("numSiret"));
		entreprise.setNumSiret(numSiret);
		
		session.saveOrUpdate(entreprise);
		transaction.commit();		
	}
  /*
	public Entreprise loadEntrepriseWithAll(Long idEntreprise)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
		Transaction transaction = session.beginTransaction();	
		
		StringBuilder qQuery = new StringBuilder();
		
		qQuery.append("from Entreprise entreprise");
		qQuery.append(" inner join fetch entreprise.address");
		qQuery.append(" inner join fetch entreprise.phoneNumbers");
		qQuery.append(" inner join fetch entreprise.group");
		qQuery.append(" where entreprise.id = :entrepriseID");
		
		Query query = session.createQuery(qQuery.toString());
		query.setLong("entrepriseID", idEntreprise);
		Entreprise entreprise = (Entreprise) query.uniqueResult();
		transaction.commit();
		return entreprise;
		
	}*/

 @SuppressWarnings("unchecked")
public List<Entreprise> searchEntrepriseBy(String numSiret, String firstName, String lastName,
		String email, String city, String street, String country, String zip) {

	 List<Entreprise> result=null;
	 Long numero = null;
	
	 
	try {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		if(numSiret != "")
			numero = Long.parseLong(numSiret);
		
		Criteria query= session.createCriteria(Entreprise.class)
				//.add(Restrictions.eqOrIsNull("NumSiret", numero))
				.add(Restrictions.like("firstName", "%"+firstName+"%" ))
				.add(Restrictions.like("lastName","%"+lastName+"%"))
				.add(Restrictions.like("email","%"+email+"%"));
					
		if(numero != null)
		{
			
			query.add(Restrictions.eq("NumSiret", numero));
					
		}
		query.createCriteria("address","addr")
			.add(Restrictions.like("addr.city","%"+city+"%"))
			.add(Restrictions.like("addr.street","%"+street+"%"))
			.add(Restrictions.like("addr.country","%"+country+"%"))
			.add(Restrictions.like("addr.zip","%"+zip+"%"));
		result=query.list();
		transaction.commit();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	return result;
  }
}
