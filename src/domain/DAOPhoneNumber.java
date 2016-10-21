package domain;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entities.Contact;
import entities.PhoneNumber;

public class DAOPhoneNumber implements IDAOPhoneNumber {
	
	public static Session session;
	
	public Boolean createContactPhoneNumber(HashMap<String, String>list, Contact contact) {
		// TODO Auto-generated method stub
	
		try {
			session=HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx=session.beginTransaction();
			
			Iterator<String> keySetIterator = list.keySet().iterator();

			while(keySetIterator.hasNext()){
								
			   String key = keySetIterator.next();
			   
			   PhoneNumber phone=new PhoneNumber(key,list.get(key).toString(),contact);
			   session.save(phone);
			}			
			tx.commit();			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return true;
	}

	public List<PhoneNumber> getPhoneNumbers(String email) {
		// TODO Auto-generated method stub
		session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		Query request = session.createQuery("from PhoneNumber as phones where phones.contact.email = :email");
		List<PhoneNumber> response =request.setString("email", email).list();		
		tx.commit();
		return response;
	}

	public void updateNumber(PhoneNumber phone) {
		// TODO Auto-generated method stub
		session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.update(phone);
		tx.commit();
	}

}
