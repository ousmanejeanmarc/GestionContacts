package servlets;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.IDAOContact;
import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.GROUPNAME;
import entities.PHONEKIND;
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
		
		//ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"}) ;
		 //IContactService contactService=(IContactService) context.getBean("beanContactService");
		IContactService contactService=new ContactService();
		String message=null;
		HashMap<String, String>phoneNumbers=new HashMap<String, String>(); //<phoneKind,phoneNumber>
		ArrayList<ContactGroup>listgroup=new ArrayList<ContactGroup>();
		
		//IContactService contactService=new ContactService();
		IAddressService addresseService=new AddressService();
		IPhoneNumberService phoneService=new PhoneNumberService();
		IContactGroupService groupService = new ContactGroupService();
		
		//choix de creation
		String type=request.getParameter("type");
		
		//info perso
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
			
		//Address
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip");
		String country=request.getParameter("country");
		
		String newgrp=request.getParameter("newGroup");
		

		
		//phone
		phoneNumbers=recupPhoneNumber(request);
		
		//recuperation du groupe
		 
		//ajout du groupe
	    ContactGroup GroupCreated=null;
	    String groupName=request.getParameter("newGroup");
	    
	    
	    if(groupName!=""){
	    	//ajout du groupe
		    GroupCreated = groupService.createContactGroup(groupName);

	    }
	    if(firstName!="" & lastName!="" && email!=""){
				
		//ajout d'une adress d'un contact
		Address address= addresseService.createAddressContact(street, city, zip, country);	
					       
		//ajout du contact
		Contact contactCreated=null;
		Entreprise entrepriseCreated=null;
		SortedMap<String, String>lesGroup;
		
		
			contactCreated= contactService.createContact(firstName, lastName, email,address);
			if(groupName!=""){
				contactService.bindContactGroupe(contactCreated, GroupCreated);
			}
			lesGroup=contactService.bindGroupe(request,contactCreated);	
			contactService.saveContact(contactCreated);
			Boolean PhoneNumberCreated= phoneService.creatContactPhoneNumber(phoneNumbers,contactCreated);

			RequestDispatcher rd=request.getRequestDispatcher("accueil.jsp");
			rd.forward(request, response);
	    }else {
	    	RequestDispatcher rd=request.getRequestDispatcher("addContact.jsp");
			rd.forward(request, response);
	    }
	}
	/**
	 * recuperation de tous les phone number
	 * @param request
	 * @param response
	 * @return
	 */
	public HashMap<String, String> recupPhoneNumber(HttpServletRequest request){
		
		String mobile,maison,bureaux,autre;
		HashMap<String, String>list=new HashMap<String, String>();
		
		if(request.getParameter("phoneKindMobile")!=null){
			mobile=request.getParameter("phoneNumberMobile");
			list.put(PHONEKIND.MOBILE.toString(), mobile);
		}
		if(request.getParameter("phoneKindBureaux")!=null){
			bureaux=request.getParameter("phoneNumberBureaux");
			list.put(PHONEKIND.BUREAUX.toString(), bureaux);
		}
		if(request.getParameter("phoneKindMaison")!=null){
			maison=request.getParameter("phoneNumberMaison");
			list.put(PHONEKIND.MAISON.toString(), maison);
		}
		if(request.getParameter("phoneKindautre")!=null){
			autre=request.getParameter("phoneNumberAutre");
			list.put(PHONEKIND.AUTRE.toString(), autre);
		}
		return list;
	}
	
	
	
	
}