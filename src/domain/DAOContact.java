package domain;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Contact;
import entities.Entreprise;
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
