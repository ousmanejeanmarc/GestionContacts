package domain;

import org.hibernate.Transaction;

import entities.Address;

public class DAOAdress implements IDAOAddress{
	
	

	
	public Address createAddress(Address address) {
		// TODO Auto-generated method stub
		
		Address addrId=null;
		//Session session=null;
		try {
			//session=HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction=DAOContact.session.beginTransaction();
			DAOContact.session.save(address);
			transaction.commit();	
			addrId=(Address)DAOContact.session.load(Address.class, address.getId());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return addrId;
		
	}
			
}
