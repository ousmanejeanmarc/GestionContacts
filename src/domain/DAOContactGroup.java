package domain;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entities.Contact;
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
		System.out.println("loadGroup"+group.getGroupName());
		transaction.commit();
		return group;
	}

	public List<ContactGroup> initialiseGroup() {
		// TODO Auto-generated method stub
		//session=HibernateUtil.getSessionFactory().getCurrentSession();
		session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		String qery="from ContactGroup";		
		List<ContactGroup> result = (List<ContactGroup>) session.createQuery(qery).list();
		transaction.commit();
		return result;
		

	}

	public void deleteGroup(Long idGroup) {
		// TODO Auto-generated method stub

		session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		ContactGroup group = (ContactGroup)session.load(ContactGroup.class, idGroup);
		session.delete(group);
		transaction.commit();
		
	}

	public List<ContactGroup> showGroup() {
		// TODO Auto-generated method stub
		session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		List<ContactGroup> groupes = (List<ContactGroup>)session.createQuery("from ContactGroup").list();
		for(ContactGroup grp : groupes)
			System.out.println("---------------> "+grp.getGroupName());
		transaction.commit();
		return groupes;
		
		
	}

	public void update(Long group,String groupName) {
		// TODO Auto-generated method stub
		session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			ContactGroup cGroup = (ContactGroup)session.load(ContactGroup.class, group);
			System.out.println("Avant update----------------->"+cGroup.getGroupName());
			cGroup.setGroupName(groupName);
			
			session.update(group);
			session.flush();
			transaction.commit();
			System.out.println("Apres update----------------->"+cGroup.getGroupName());
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();			
		}		
	}

	public boolean removeContact(Contact contact, ContactGroup group) {
		// TODO Auto-generated method stub
		
		session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		if(contact.getGroup().contains(group))
		{
			contact.getGroup().remove(group);
		}
		if(group.getContacts().contains(contact))
		{
			group.getContacts().remove(contact);
		}
		session.update(contact);
		session.update(group);
		transaction.commit();
		
		return true;
	}

	public void update(ContactGroup groupName) {
		// TODO Auto-generated method stub
		session=HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();						
			
			session.update(groupName);
			//session.flush();
			transaction.commit();
			System.out.println("Apres update----------------->"+groupName.getGroupName());
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();			
		}	
	}

}
