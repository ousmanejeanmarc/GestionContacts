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
		
		String message=null;
		HashMap<String, String>phoneNumbers=new HashMap<String, String>(); //<phoneKind,phoneNumber>
		ArrayList<ContactGroup>listgroup=new ArrayList<ContactGroup>();
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
		
		
		
		//Phone 
		String phoneKind=request.getParameter("phoneKind");
		String phoneNumber=request.getParameter("phoneNumber");
		phoneNumbers=recupPhoneNumber(request);
		
		//recuperation du groupe
		String group = request.getParameter("newGroup");
		//listgroup=recuGroup(request);
		
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
			    
			    
			    
			    
			    if(type.equals("Contact")){
			    	
					contactCreated= contactService.createContact(firstName, lastName, email,address);
					contactService.bindContactGroupe(contactCreated, GroupCreated);
					bindContactGroupe(request,contactCreated);
					contactService.saveContact(contactCreated);
					Boolean PhoneNumberCreated= phoneService.creatContactPhoneNumber(phoneNumbers,contactCreated);
				}else if(type.equals("Entreprise")){
			    //ajout d'une entreprise
				
					//numero siret de l'entreprise7
					long numSiret=Long.parseLong(request.getParameter("numSiret"));
					entrepriseCreated= contactService.createEntreprise(firstName, lastName, email,address,numSiret);
					contactService.bindContactGroupe(entrepriseCreated, GroupCreated);
					bindContactGroupe(request,entrepriseCreated);
					contactService.saveEntreprise(entrepriseCreated);
					  Boolean PhoneNumberCreated= phoneService.creatContactPhoneNumber(phoneNumbers,entrepriseCreated);
				}
			    
				//sauvegarde en base des contacts et groupe
			    //groupService.save(listgroup);
			    //groupService.save(GroupCreated);
				
				
				
			    //ajout du phone number
			    //PhoneNumber PhoneNumber= phoneService.creatContactPhoneNumber(phoneKind, phoneNumber,contactCreated);
			   // Boolean PhoneNumberCreated= phoneService.creatContactPhoneNumber(phoneNumbers,entrepriseCreated);
			   
			    
			    
			    
			    
			    
			    RequestDispatcher rd=request.getRequestDispatcher("accueil.jsp");
				rd.forward(request, response);
			  
				
		}else {
			message="Les champs ne doivent pas être vides";
			request.setAttribute("Message", message);
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
	
	/**
	 * recuperation de tous les phone number
	 * @param request
	 * @param response
	 * @return
	 */
	/*public ArrayList<ContactGroup> recuGroup(HttpServletRequest request){
		
		
		ArrayList<ContactGroup>list=new ArrayList<ContactGroup>();
		ContactGroup ctgrp;
		
		if(request.getParameter("gamis")!=null){
		
			String value= request.getParameter("gamis"); 
			String id = request.getParameter(value);
			Long idGroup = Long.parseLong(id);
			ContactGroupService serviceG = new ContactGroupService();
			ContactGroup groupe = serviceG.loadGroup(idGroup);
			
			ctgrp=new ContactGroup();
			ctgrp.setGroupName(GROUPNAME.Amis.toString());
			
			list.add(ctgrp);
		}
		if(request.getParameter("gfamille")!=null){
			ctgrp=new ContactGroup();
			ctgrp.setGroupName(GROUPNAME.Famille.toString());
			
			list.add(ctgrp);
			
		}
		if(request.getParameter("gcollegue")!=null){
			
			ctgrp=new ContactGroup();
			ctgrp.setGroupName(GROUPNAME.Collegue.toString());
			
			list.add(ctgrp);
		}
		
		return list;
	}*/
	
	public void bindContactGroupe(HttpServletRequest request, Contact contactCreated ){
		
		
		Enumeration<String> parametersName= request.getParameterNames();
		String parameterName= null;
		HashMap<String, String>params=new HashMap<String, String>();
		try {
			while((parameterName=parametersName.nextElement())!=null){
				params.put(parameterName, request.getParameter(parameterName));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		TreeMap<String, String>valeur=new TreeMap<String, String>();
		valeur.putAll(params);
		SortedMap<String, String> group =valeur.subMap("groupes0", "groupesz");

	}
}
