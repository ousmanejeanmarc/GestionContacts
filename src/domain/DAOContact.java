package domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import entities.Address;
import entities.Contact;
import entities.Entreprise;
import entities.PhoneNumber;
import util.HibernateUtil;

public class DAOContact implements IDAOContact{
	
		
	
	public Contact createContact(Contact contact) {
		// TODO Auto-generated method stub
	
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			session.save(contact);
			transaction.commit();
						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}	
		return contact;
	}
	public Entreprise createEntreprise(Entreprise entrp){
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(entrp);
			transaction.commit();
						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}	
		return entrp;
	}

	
	
	
	
	public boolean deleteContact(Long idContact) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try
		{
			Contact contact = (Contact)session.load(Contact.class, idContact);
			System.out.println("le nom du contact supprimé "+contact.getFirstName());
			session.delete(contact);
			transaction.commit();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			
			return false;
		}
		
		return true;
	}

	public Entreprise loadEntreprise(Long idEntreprise) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();	
		Entreprise entreprise = (Entreprise)session.load(Entreprise.class, idEntreprise);
		transaction.commit();
		return entreprise;
	}
	public Contact findContactById(long contactId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();		
		Contact contact = (Contact) session.load(Contact.class, contactId);	
		transaction.commit();
		return contact;
	}
/*
	public ArrayList<Contact> findContactByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}*/

/*	public ArrayList<Contact> findContactByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Contact> searchContactByFirstName(String firstName) {
		// TODO Auto-generated method stub
		ArrayList<Contact> result=null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
		
			String qery="from Contact as c where c.firstName= :firstName";		
			result= (ArrayList<Contact>) session.createQuery(qery).setString("firstName", firstName).list();
	
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		return result;
	}*/
/*	@SuppressWarnings("unchecked")
	public List<Contact> searchContactBy(String firstName,String lastName,String email,
			String city,String street,String country, String zip) {
		
		List<Contact> result=null;
		
	
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();

			
			result= session.createCriteria(Contact.class)
					.add(Restrictions.like("firstName", "%"+firstName+"%" ))
					.add(Restrictions.like("lastName","%"+lastName+"%"))
					.add(Restrictions.like("email","%"+email+"%"))
					.createCriteria("address","addr")
					.add(Restrictions.like("addr.city","%"+city+"%"))
					.add(Restrictions.like("addr.street","%"+street+"%"))
					.add(Restrictions.like("addr.country","%"+country+"%"))
					.add(Restrictions.like("addr.zip","%"+zip+"%"))
					.list();	
	
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> searchContactByEntreprise(String firstName,String lastName,String email,
			String city,String street,String country, String zip, long numSiret,String phone) {
		
		
		List<Contact>result=null;
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
					
			result= session.createCriteria(Contact.class)
					.add(Restrictions.like("firstName", "%"+firstName+"%" ))
					.add(Restrictions.like("lastName","%"+lastName+"%"))
					.add(Restrictions.like("email","%"+email+"%"))
					//.createCriteria("phoneNumber","phones")
					.createCriteria("address","addr")
					.add(Restrictions.like("addr.city","%"+city+"%"))
					.add(Restrictions.like("addr.street","%"+street+"%"))
					.add(Restrictions.like("addr.country","%"+country+"%"))
					.add(Restrictions.like("addr.zip","%"+zip+"%"))
					.add(Restrictions.eq("phones.PhoneNumber", phone))
					.list();
			System.out.print("------------------------------------------------>taille"+result.size());
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}*/
	
	public Contact findContactById(Long contactId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();		
		Contact contact = (Contact) session.load(Contact.class, contactId);	
		transaction.commit();
		return contact;
	}

	public ArrayList<Contact> findContactByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Contact> findContactByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Contact> searchContactByFirstName(String firstName) {
		// TODO Auto-generated method stub
		ArrayList<Contact> result=null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
		
			String qery="from Contact as c where c.firstName= :firstName";		
			result= (ArrayList<Contact>) session.createQuery(qery).setString("firstName", firstName).list();
	
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		return result;
	}
	@SuppressWarnings("unchecked")
	public List<Contact> searchContactBy(String firstName,String lastName,String email,
			String city,String street,String country, String zip) {
		
		List<Contact> result=null;
		
	
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();

			
			result= session.createCriteria(Contact.class)
					.add(Restrictions.like("firstName", "%"+firstName+"%" ))
					.add(Restrictions.like("lastName","%"+lastName+"%"))
					.add(Restrictions.like("email","%"+email+"%"))
					.createCriteria("address","addr")
					.add(Restrictions.like("addr.city","%"+city+"%"))
					.add(Restrictions.like("addr.street","%"+street+"%"))
					.add(Restrictions.like("addr.country","%"+country+"%"))
					.add(Restrictions.like("addr.zip","%"+zip+"%"))
					.list();	
	
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> searchContactByEntreprise(String firstName,String lastName,String email,
			String city,String street,String country, String zip, long numSiret,String phone) {
		
		
		List<Contact>result=null;
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
					
			result= session.createCriteria(Contact.class)
					.add(Restrictions.like("firstName", "%"+firstName+"%" ))
					.add(Restrictions.like("lastName","%"+lastName+"%"))
					.add(Restrictions.like("email","%"+email+"%"))
					//.createCriteria("phoneNumber","phones")
					.createCriteria("address","addr")
					.add(Restrictions.like("addr.city","%"+city+"%"))
					.add(Restrictions.like("addr.street","%"+street+"%"))
					.add(Restrictions.like("addr.country","%"+country+"%"))
					.add(Restrictions.like("addr.zip","%"+zip+"%"))
					.add(Restrictions.eq("phones.PhoneNumber", phone))
					.list();
			System.out.print("------------------------------------------------>taille"+result.size());
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public void updateContact(Contact contact, HashMap<String, String> attributes, Address addressContact, List<PhoneNumber> phones) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		contact.setEmail(attributes.get("email"));
		contact.setFirstName(attributes.get("firstName"));
		contact.setLastName(attributes.get("lastName"));
		//Mise à jour pour maintenance bidirectionnelle
		contact.setAddress(addressContact);		
		contact.setPhoneNumber(new HashSet<PhoneNumber>(phones));
		
		session.update(contact);
		transaction.commit();

	

	}

	
	public Contact loadContact(Long idContact) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();		
		Transaction transaction = session.beginTransaction();	
		Contact contact = (Contact)session.load(Contact.class, idContact);
		String email = contact.getEmail();
	//	System.out.println("loadContact "+contact.getFirstName());
		transaction.commit();
		return contact;
	}


	
	
}
