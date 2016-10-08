package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Address;
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
				Address idAdressCreated=addresseService.createAddressContact(street, city, zip, country);
			  
			    
			    //ajout du phone number
			    boolean isPhoneNumberCreated=phoneService.creatContactPhoneNumber(phoneKind, phoneNumber);
			    //ajout du groupe
			    boolean isGroupCreated = groupService.createContactGroup(group);
			   
			    //ajout du contact
				boolean isContactCreated=contactService.createContact(firstName, lastName, email,idAdressCreated);
				
			    //System.out.println("contact: "+isContactCreated+"addr: "+isAdressCreated+"phone: "+isPhoneNumberCreated);
			    if(isContactCreated &&  isPhoneNumberCreated && isGroupCreated){
					response.setContentType("text/html");
					message="Le contact:"+firstName+" "+lastName+" "+", a bien été enregistré";
					request.setAttribute("Message", message);
					RequestDispatcher rd=request.getRequestDispatcher("accueil.jsp");
					rd.forward(request, response);
				}else {
					message="Un problème est survenu lors de la création du conact";
					request.setAttribute("Message", message);
					RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				
		}else {
			message="Les champs ne doivent pas être vides";
			request.setAttribute("Message", message);
			RequestDispatcher rd=request.getRequestDispatcher("addContact.jsp");
			rd.forward(request, response);
		}
		
		
		//creation de l'instance de DAOContact et appel de sa methode addContact
			
		
		
		//je vines fnbiene*psrzpgn
		
		
		
		
		//ajout du num de telephone
		//daoPhoneNumer.addContactPhoneNumber(phoneKind, phoneNumber);*/
		
		
		
	}

}
