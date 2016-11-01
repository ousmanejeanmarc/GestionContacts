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
import services.IAddressService;
import services.IContactService;
import services.IPhoneNumberService;
import services.PhoneNumberService;

public class UpdateContact extends HttpServlet {
	
	
//	 ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	
	IContactService contactService = new ContactService();
	IAddressService addressService = new AddressService();
	IPhoneNumberService phoneService = new PhoneNumberService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub	

		//reception traitement servelet
	/*	if(request.getParameter("idContact")!=null)
		{
		
			Enumeration <String> parametersName = request.getParameterNames();
			String parameterName = null;
			HashMap<String,String>attributes = new HashMap<String, String>();
			
			if(request.getParameter("typeOfContact").equals("entreprise"))
			{
				attributes.put("typeOfContact","entreprise");
			}
			else
				attributes.put("typeOfContact",request.getParameter("typeOfContact"));
			
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
			
			Long idContact = Long.parseLong(request.getParameter("id"));
			Entreprise entreprise = null;
			Contact contact = null;
			String typeOfContact = null;
			
			Address address = null;
			List<PhoneNumber>phones = null;
			//preciser dans le champs hidden le type de l'entreprise
			try {
				typeOfContact = request.getParameter("typeOfContact").trim();
				System.out.println("le paramerte        "+ typeOfContact );
			} catch (Exception e) {
				// TODO: handle exception
				
			}
			if(typeOfContact != null && typeOfContact.equals("entreprise"))
			{
				request.setAttribute("isEntreprise", "true");
				 entreprise = contactService.loadEntrepriseW(idContact);
				 
				// contact = (Contact)entreprise;
				 request.setAttribute("contact", entreprise);
				 
					 address =entreprise.getAddress();
					 phones = phoneService.getPhoneNumbers(entreprise.getEmail());	
			}
			else 
			{
				request.setAttribute("isEntreprise", "false");
				contact = contactService.loadContactW(idContact);
				request.setAttribute("contact", contact);
				
				 address =contact.getAddress();
				System.out.println("le ontacte est simplement   "+address.getStreet());
				//Phone Numbers
				phones = phoneService.getPhoneNumbers(contact.getEmail());	
			}
		//	System.out.println("mail "+contact.getEmail());
			//address Contact
			//Address address = addressService.getAddressContact(contact);
			/*   ----  */
		//	Address address =contact.getAddress();
		//	System.out.println("le ontacte est simplement   "+address.getStreet());
			//Phone Numbers
	//		List<PhoneNumber>phones = phoneService.getPhoneNumbers(contact.getEmail());	
		/*	List<PhoneNumber>phones = new ArrayList<PhoneNumber>(contact.getPhoneNumber());	
				for(PhoneNumber phone: phones)
					System.out.println("-------------------------"+phone.getPhoneKind());
			request.setAttribute("phones", phones);
			request.setAttribute("address", address);		
			RequestDispatcher rd=request.getRequestDispatcher("readyToUpdate.jsp");
			rd.forward(request, response);	
			
		}
		*/
		
	}
		
	
}
