package domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.transaction.TransactionManager;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.PhoneNumber;
import util.HibernateUtil;


public class DAOContact implements IDAOContact{
	
	
		
	
	public Contact createContact(Contact contact) {
		
	
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			session.save(contact);
			transaction.commit();
						
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}	
		return contact;
	}
/*	
	public boolean deleteContactPhones(Contact contact)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.createQuery("delete PhoneNumber as phone where  phone.contact= :contact").setEntity("contact", contact).executeUpdate();
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	*/
	
	public boolean deleteContact(Long idContact) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try
		{
			Contact contact = (Contact)session.load(Contact.class, idContact);			
			session.createQuery("delete from Contact as contact where  contact.email= :email").setString("email", contact.getEmail()).executeUpdate();
			session.flush();
			transaction.commit();			
		} 
		catch (Exception e) 
		{
		//	transaction.rollback();
			e.printStackTrace();
			
			return false;
		}
		
		return true;
	}

	
	public Contact findContactById(long contactId) {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();		
		Contact contact = (Contact) session.load(Contact.class, contactId);	
		transaction.commit();
		return contact;
	}
/*
	public ArrayList<Contact> findContactByLastName(String lastname) {
		
		return null;
	}*/

/*	public ArrayList<Contact> findContactByEmail(String email) {
		
		return null;
	}
	public ArrayList<Contact> searchContactByFirstName(String firstName) {
		
		ArrayList<Contact> result=null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
		
			String qery="from Contact as c where c.firstName= :firstName";		
			result= (ArrayList<Contact>) session.createQuery(qery).setString("firstName", firstName).list();
	
		} catch (Exception e) {
			
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
			
		}
		
		return result;
	}*/
	
	public Contact findContactById(Long contactId) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();		
		Contact contact = (Contact) session.load(Contact.class, contactId);	
		Hibernate.initialize(contact.getAddress());
		Hibernate.initialize(contact.getPhoneNumbers());
		transaction.commit();
		return contact;
	}

	public ArrayList<Contact> searchContactByFirstName(String firstName) {
		
		ArrayList<Contact> result=null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
		
			String qery="from Contact as c where c.firstName= :firstName";		
			result= (ArrayList<Contact>) session.createQuery(qery).setString("firstName", firstName).list();
			//transaction.commit();
		} catch (Exception e) {
			
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
			transaction.commit();
		} catch (Exception e) {
			
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
			
		}
		
		return result;
	}
	
	public void updateContact(Contact contact) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();	
		session.update(contact);
		transaction.commit();

	

	}

	
	public Contact loadContact(Long idContact) {
		
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();		
		Transaction transaction = session.beginTransaction();	
		Contact contact = (Contact)session.load(Contact.class, idContact);
		String email = contact.getEmail();
	//	System.out.println("loadContact "+contact.getFirstName());
		transaction.commit();
		return contact;
	}
	
/*	public void fetchInfo(Contact contact)
	{
		if(!Hibernate.isInitialized(contact))//pas necessaire
			return;
		Hibernate.initialize(contact.getPhoneNumber());
		for(PhoneNumber phone: contact.getPhoneNumber())
			Hibernate.initialize(phone);
		Hibernate.initialize(contact.getGroup());
		for(ContactGroup groupe: contact.getGroup())
			Hibernate.initialize(groupe);
	}
	*/
	
	public List<Contact> getAllContact() {
	// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();			
		Transaction transaction = session.beginTransaction();	
		List<Contact> contacts = session.createQuery(" from Contact as contact where contact.class=Contact order by contact.firstName ASC ").list();
	
		transaction.commit();	

		return contacts;
		}
	
	
	


	
	
}
