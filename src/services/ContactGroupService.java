package services;



import java.util.ArrayList;
import java.util.List;

import domain.DAOContactGroup;
import domain.IDAOContactGroup;
import entities.ContactGroup;


public class ContactGroupService implements IContactGroupService{
	
	private IDAOContactGroup daoGroup=new DAOContactGroup();
	public List<ContactGroup> list;
	
	public ContactGroup createContactGroup(String groupName) {
		// TODO Auto-generated method stub
			
		ContactGroup groupe=new ContactGroup();
		
		groupe.setGroupName(groupName);
		return groupe;
	}
	
	public boolean save (ContactGroup group){
		
		
		//appel du DAO
		
		Boolean createdGroup = daoGroup.createGroup(group);
		if(createdGroup){
			return true;
		}return false;
	}

	public ContactGroup loadGroup(Long idGroup) {
		// TODO Auto-generated method stub
		return daoGroup.loadGroup(idGroup);
	}
	
	public List<ContactGroup> initialiseGroup() {
		// TODO Auto-generated method stub
		
		
		
		 this.list=daoGroup.initialiseGroup();
		return list;
		
	}

	public List<ContactGroup> showGroup() {
		// TODO Auto-generated method stub
		return null;
	}

}
