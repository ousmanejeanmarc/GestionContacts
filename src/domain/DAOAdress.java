package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entities.Address;

public class DAOAdress implements IDAOAddress{
	
	public static Session session;
	
	public Address createAddress(Address address) {
		// TODO Auto-generated method stub
		
		Address addrId=null;
		try {
			session=HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			session.save(address);
			transaction.commit();
			addrId=(Address) session.load(Address.class, address.getId());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return address;
		
	}
			
}
