package domain;


import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entities.ContactGroup;

public class DAOContactGroup implements IDAOContactGroup {
	
	public static Session session;
	
	public ContactGroup createGroup(ContactGroup groupe) {
		// TODO Auto-generated method stub
		//Session session=null;
		long createdGroup=-1;
		
		try {
			session=HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			session.save(groupe);
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return groupe;
	}

}
