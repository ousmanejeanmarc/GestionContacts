package domain;


import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entities.PhoneNumber;

public class DAOPhoneNumber implements IDAOPhoneNumber {
	public static Session session;
	
	public PhoneNumber createContactPhoneNumber(PhoneNumber phone) {
		// TODO Auto-generated method stub
		PhoneNumber createdPhone=null;
	
		try {
			session=HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx=session.beginTransaction();
			session.save(phone);
			tx.commit();
			//createdPhone=(PhoneNumber)DAOContact.session.load(PhoneNumber.class, phone.getId());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return phone;
	}


}
