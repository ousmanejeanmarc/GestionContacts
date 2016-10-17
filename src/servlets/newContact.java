package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.PhoneNumber;
import services.AddressService;
import services.ContactGroupService;
import services.ContactService;
import services.IAddressService;
import services.IContactGroupService;
import services.IContactService;
import services.IPhoneNumberService;
import services.PhoneNumberService;

/**
 * Servlet implementation class newContact
 */
public class newContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String message=null;
		
		//recuperation des info de la personne
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
	
		
		String choice=request.getParameter("choice");
		System.out.println("le choix est :"+choice);
		
		//Address
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip");
		String country=request.getParameter("country");
		
		//Phone 
		String phoneKind=request.getParameter("phoneKind");
		String phoneNumber=request.getParameter("phoneNumber");
		
		//recuperation du groupe
		String group = request.getParameter("group");
		
		//petite verification
		if(firstName!="" & lastName!=" " && email!=" ") {
				
				IContactService contactService=new ContactService();
				IAddressService addresseService=new AddressService();
				IPhoneNumberService phoneService=new PhoneNumberService();
				IContactGroupService groupService = new ContactGroupService();
				
				
				//ajout d'une adress d'un contact
				Address address= addresseService.createAddressContact(street, city, zip, country);	
				
				//ajout du groupe
			    ContactGroup GroupCreated = groupService.createContactGroup(group);
			    
			    //ajout du contact
			    Contact contactCreated=null;
			    Entreprise entrepriseCreated=null;
			   
			    if(choice.equals("Contact")){
			    	System.out.println("contact");
					contactCreated= contactService.createContact(firstName, lastName, email,address);
					contactService.bindContactGroupe(contactCreated, GroupCreated);
					contactService.saveContact(contactCreated);
				}else if(choice.equals("Entreprise")){
			    //ajout d'une entreprise
					System.out.println("entreprise");
					//numero siret de l'entreprise7
					long numSiret=Long.parseLong(request.getParameter("numSiret"));
					entrepriseCreated= contactService.createEntreprise(firstName, lastName, email,address,numSiret);
					contactService.bindContactGroupe(entrepriseCreated, GroupCreated);
					contactService.saveEntreprise(entrepriseCreated);
				}
			  	    
				//sauvegarde en base des contacts et groupe
				groupService.save(GroupCreated);
				
				
				
			    //ajout du phone number
			    PhoneNumber PhoneNumber= phoneService.creatContactPhoneNumber(phoneKind, phoneNumber,contactCreated);
			   	
			    RequestDispatcher rd=request.getRequestDispatcher("accueil.jsp");
				rd.forward(request, response);
			  
				
		}else {
			message="Les champs ne doivent pas être vides";
			request.setAttribute("Message", message);
			RequestDispatcher rd=request.getRequestDispatcher("addContact.jsp");
			rd.forward(request, response);
		}
		
				
	}
	
}
