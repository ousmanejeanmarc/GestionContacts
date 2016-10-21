package domain;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entities.Address;
import entities.Contact;

public class DAOAdress implements IDAOAddress{
	
	public static Session session;
	
	public Address createAddress(Address address) {
		// TODO Auto-generated method stub
		
		
		try {
			session=HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			session.save(address);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return address;
		
	}
	public  boolean updateAddress(Address address)
	{
		session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try 
		{

			session.update(address);
			transaction.commit();
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	public Address getAddressContact(Contact contact) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction= session.beginTransaction();
		//System.out.println("mon email "+contact.getEmail());
		Query request = session.createQuery("select contact.address from Contact as contact where contact = :contact");
		List<Address> response = request.setEntity("contact", contact).list();
		transaction.commit();
		return response.get(0);
	}
	public Address getAddressContact(String email) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction= session.beginTransaction();
		//System.out.println("mon email "+contact.getEmail());
		Query request = session.createQuery("select contact.address from Contact as contact where contact.email = :email");
		List<Address> response = request.setString("email", email).list();
		transaction.commit();
		return response.get(0);//NULL accepted
	}

	public boolean updateAddress(Address address,
			HashMap<String, String> attributes) {
		// TODO Auto-generated method stub		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction= session.beginTransaction();
		try {
			session.update(address);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			return false;
		}		
		return true;
	}
			
}
