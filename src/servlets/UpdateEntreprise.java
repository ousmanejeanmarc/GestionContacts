package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import org.hibernate.Hibernate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.DAOAdress;
import entities.Address;
import entities.Contact;
import entities.Entreprise;
import entities.PhoneNumber;
import services.AddressService;
import services.ContactService;
import services.EntrepriseService;
import services.IAddressService;
import services.IContactService;
import services.IEntrepriseService;
import services.IPhoneNumberService;
import services.PhoneNumberService;

public class UpdateEntreprise extends HttpServlet {
	
	
//	 ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	
	IContactService contactService = new ContactService();
	IEntrepriseService entrepriseService = new EntrepriseService();
	IAddressService addressService = new AddressService();
	IPhoneNumberService phoneService = new PhoneNumberService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub	

		//reception traitement servelet
		if(request.getParameter("idEntreprise")!=null)
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
			
			entrepriseService.updateEntreprise(attributes);
		}
		else
		{			
			//delegation vers la servelet de traitement			
			//le type hidden aura été mis aussi pour le type de contact
			
			Long idEntreprise = Long.parseLong(request.getParameter("id"));
			Entreprise entreprise = null;		
			Address address = null;
			List<PhoneNumber>phones = null;

			entreprise = entrepriseService.loadEntreprise(idEntreprise);
			request.setAttribute("entreprise", entreprise);
			
			address = addressService.getAddressContact((Contact)entreprise);
		/*	address =contact.getAddress();
			System.out.println("le ontacte est simplement   "+address.getStreet());*/
				//Phone Numbers
			phones = phoneService.getPhoneNumbers(entreprise.getEmail());

			
			request.setAttribute("phones", phones);
			request.setAttribute("address", address);		
			RequestDispatcher rd=request.getRequestDispatcher("readyToUpdateEntreprise.jsp");
			rd.forward(request, response);	
			
		}
		
		
	}
		
	
}
