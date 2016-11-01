package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AddressService;
import services.ContactGroupService;
import services.EntrepriseService;
import services.IAddressService;
import services.IContactGroupService;
import services.IEntrepriseService;
import services.IPhoneNumberService;
import services.PhoneNumberService;
import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.PHONEKIND;

public class NewEntreprise extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		IEntrepriseService entrepriseService=new EntrepriseService();
		HashMap<String, String>phoneNumbers=new HashMap<String, String>(); //<phoneKind,phoneNumber>

		IAddressService addresseService=new AddressService();
		IPhoneNumberService phoneService=new PhoneNumberService();
		IContactGroupService groupService = new ContactGroupService();

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

		Entreprise entrepriseCreated=null;

			long numSiret=Long.parseLong(request.getParameter("numSiret"));
			entrepriseCreated= entrepriseService.createEntreprise(firstName, lastName, email,address,numSiret);
			if(groupName!=""){
				entrepriseService.bindContactGroupe(entrepriseCreated, GroupCreated);
				
			}
			entrepriseService.bindGroupe(request,entrepriseCreated);
			entrepriseService.saveEntreprise(entrepriseCreated);
			phoneService.creatContactPhoneNumber(phoneNumbers,entrepriseCreated);
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
