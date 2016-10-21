package servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import domain.DAOAdress;
import entities.Address;
import entities.Contact;
import entities.Entreprise;
import entities.PhoneNumber;
import services.AddressService;
import services.ContactService;
import services.IAddressService;
import services.IContactService;
import services.IPhoneNumberService;
import services.PhoneNumberService;

public class UpdateContact extends HttpServlet {
	
	IContactService contactService = new ContactService();
	IAddressService addressService = new AddressService();
	IPhoneNumberService phoneService = new PhoneNumberService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub	

		//reception traitement servelet
		if(request.getParameter("firstName")!=null)
		{
			
			Enumeration <String> parametersName = request.getParameterNames();
			String parameterName = null;
			HashMap<String,String>attributes = new HashMap<String, String>();
			
			try
			{
				while((parameterName=parametersName.nextElement())!=null)
				{
					attributes.put(parameterName, request.getParameter(parameterName));
				}				
				
			} 
			catch (Exception e){}
			
			contactService.updateContact(attributes);
		}
		else
		{			
			//delegation vers la servelet de traitement			
			//le type hidden aura été mis aussi pour le type de contact
			
			Long idContact = Long.parseLong(request.getParameter("idContact"));
			Entreprise entreprise = null;
			Contact contact = null;
			//preciser dans le champs hidden le type de l'entreprise
			if(request.getParameter("typeContact").trim().compareTo("entreprise")== 0)
			{
				request.setAttribute("isEntreprise", true);
				 entreprise = contactService.loadEntreprise(idContact);
				 
				 contact = (Contact)entreprise;
				 request.setAttribute("contact", entreprise);
			}
			else 
			{
				request.setAttribute("isEntreprise", false);
				contact = contactService.loadContact(idContact);
				request.setAttribute("contact", contact);
			}
		//	System.out.println("mail "+contact.getEmail());
			//address Contact
			Address address = addressService.getAddressContact(contact);
			//Phone Numbers
			List<PhoneNumber>phones = phoneService.getPhoneNumbers(contact.getEmail());	
			
			request.setAttribute("phones", phones);
			request.setAttribute("address", address);		
			RequestDispatcher rd=request.getRequestDispatcher("readyToUpdate.jsp");
			rd.forward(request, response);	
			
		}
		
		
	}
		
	
}
