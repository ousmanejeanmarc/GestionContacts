package domain;


import java.util.HashMap;
import java.util.Iterator;

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


}
