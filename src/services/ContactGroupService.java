package services;



import domain.DAOContactGroup;
import domain.IDAOContactGroup;
import entities.ContactGroup;

public class ContactGroupService implements IContactGroupService{
	
	public ContactGroup createContactGroup(String groupName) {
		// TODO Auto-generated method stub
		boolean isCreated=false;
		ContactGroup createdGroup=null;
		
		ContactGroup groupe=new ContactGroup();
		
		groupe.setGroupName(groupName);
				
		//appel du DAO
		//IDAOContactGroup daoGroup=new DAOContactGroup();
		
		
		//createdGroup=daoGroup.createGroup(groupe);
		
		//return createdGroup;
		return groupe;
	}
	
	public boolean save (ContactGroup group){
		
		
		//appel du DAO
		IDAOContactGroup daoGroup=new DAOContactGroup();
		ContactGroup createdGroup = daoGroup.createGroup(group);
		if(createdGroup!=null){
			return true;
		}return false;
	}
	
	

}
