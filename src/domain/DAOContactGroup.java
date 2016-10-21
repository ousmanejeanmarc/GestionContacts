package domain;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import entities.ContactGroup;

public class DAOContactGroup implements IDAOContactGroup {
	
	public static Session session;
	
	public Boolean createGroup(ContactGroup groupe) {
		// TODO Auto-generated method stub
	
		ContactGroup ctg;
		try {
			session=HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			session.save(groupe);
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return true;
	}

	public ContactGroup loadGroup(Long idGroup) {
		// TODO Auto-generated method stub
		session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		ContactGroup group = (ContactGroup)session.load(ContactGroup.class, idGroup);
		transaction.commit();
		return group;
	}

	public List<ContactGroup> initialiseGroup() {
		// TODO Auto-generated method stub
		//session=HibernateUtil.getSessionFactory().getCurrentSession();
	/*	session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		String qery="from ContactGroup";		
		List<ContactGroup> result = (List<ContactGroup>) session.createQuery(qery).list();
		transaction.commit();
		return result;*/
		return null;

	}

}
