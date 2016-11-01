package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.DAOContact;
import domain.IDAOContact;
import entities.Contact;
import entities.ContactGroup;
import services.ContactGroupService;
import services.ContactService;
import services.IContactGroupService;
import services.IContactService;

public class DeleteGroup extends HttpServlet{
	
	private IContactGroupService groupService = new ContactGroupService();
	private IContactService contactService = new ContactService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	super.doPost(req, resp);

		//String idGroup=request.getParameter("idGroup");//identifiants des contacts		
		//creation de l'instance de DAOContact et appel de sa methode addContact		
		//Je supprime tous les groupes de la base 
	//	groupService.removeAll();
		System.out.println("Essaie de test de suppression 1 er groupe " +request.getParameter("idGroup") );
	//	Long idGroup=Long.parseLong(request.getParameter("idGroup"));
	//	groupService.removeGroup(idGroup);
		System.out.println("---------------------Simulaion d'une sequence d'execution----------");
		//creation contacts
		Contact contact1 = new Contact("toto", "lenga", "jean@gmail");
		
		
		Contact contact2 = new Contact("mazy", "marie", "toto@gmail");
		
		//creation groupes
		ContactGroup group1 = new ContactGroup();
		group1.setGroupName("famille");
		
		
		ContactGroup group2 = new ContactGroup();
		group2.setGroupName("amie");
	
		/********/
		group1.addContact(contact1);
		group1.addContact(contact2);
		/*******/
		group2.addContact(contact1);
		group2.addContact(contact2);
		
		
		groupService.update(group2);
		groupService.update(group1);
		contactService.createContact(contact1);
		contactService.createContact(contact2);
		
		groupService.createContactGroup(group1);
		groupService.createContactGroup(group2);
		
		groupService.removeFromGroup(contact1, group2);
		groupService.removeFromGroup(contact2, group1);
		
		/******Voir resultat en base ********/
		
		
		
		
		
	}

}
