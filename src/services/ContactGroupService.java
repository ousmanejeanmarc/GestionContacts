package services;



import domain.DAOContactGroup;
import domain.IDAOContactGroup;
import entities.ContactGroup;

public class ContactGroupService implements IContactGroupService{
	
	public boolean createContactGroup(String groupName) {
		// TODO Auto-generated method stub
		boolean isCreated=false;
		
		ContactGroup groupe=new ContactGroup();
		
		groupe.setGroupName(groupName);
				
		//appel du DAO
		IDAOContactGroup daoGroup=new DAOContactGroup();
		
		//creation de l'addresse
		long createdGroup=daoGroup.createGroup(groupe);
		if(createdGroup!= -1){
			isCreated=true;
		}
		
		return isCreated;
	}
	
	
	

}
