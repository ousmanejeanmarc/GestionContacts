package domain;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	public ArrayList<Contact> searchContactByFirstName(String firstName) {
		// TODO Auto-generated method stub
		ArrayList<Contact> result=null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
		
			String qery="from Contact as c where c.firstName= :firstName";		
			result= (ArrayList<Contact>) session.createQuery(qery).setString("firstName", firstName).list();
	
		} catch (Exception e) {
			// TODO: handle exception
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
	
		} catch (Exception e) {
			// TODO: handle exception
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
			// TODO: handle exception
		}
		
		return result;
	}
	
	
}
