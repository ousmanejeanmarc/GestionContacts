package domain;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Contact;
import util.HibernateUtil;

public class DAOContact implements IDAOContact{
	
		public static Session session;

	
	public Contact createContact(Contact contact) {
		// TODO Auto-generated method stub
		Contact createdContact=null;
	
		
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			Transaction transaction=session.beginTransaction();
			session.save(contact);
			transaction.commit();
			createdContact=(Contact) session.load(Contact.class, contact.getId());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return createdContact;
	}

	
	
	
	
	public boolean deleteContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact findContactById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Contact> findContactByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Contact> findContactByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
