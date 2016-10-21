<%@page import="util.HibernateUtil"%>
<%@page import="entities.Contact"%>
<%@page import="entities.Entreprise"%>
<%@page import="entities.Address"%>
<%@page import="entities.PhoneNumber"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="services.ContactService"%>
<%
	/*Pour savoir si c'est une entreprise ou  un simple contact placé le input  de type hidden  et comme name l'idContact
	et value "entreprise" "contact" pour entreprise ou contact*/
		boolean isEntreprise = (Boolean)request.getAttribute("isEntreprise");
		String pageResponse = "<html><head><title>Mise à jour Contact</title></head><body>";
		pageResponse += "<form method='post' action='UpdateContact'>";
		pageResponse +="<fieldset><legend>Modifier les inforations du Contact</legend>";
		pageResponse += "<table>";
		Entreprise entreprise = null;
		Contact contact = null;
		
		Address address = (Address)request.getAttribute("address");
		String city = (address==null)?"":address.getCity();
		String street = (address==null)?"":address.getCity();
		String Zip =  (address==null)?"":address.getZip();
		String country = (address==null)?"": address.getCountry();
		
		List<PhoneNumber> phones =(List<PhoneNumber>) request.getAttribute("phones");
		for(PhoneNumber phone : phones)
		{
			System.out.println("numero dans jsp -------------->"+ phone.getPhoneNumber());
		}
		
		
		if(isEntreprise)
		{
			entreprise =(Entreprise)request.getAttribute("contact");
			pageResponse += "<tr align='center'><td align='right'><i>NumeroSiret:</td> ";
			pageResponse += "<td><input type='text' name='numSiret' value='"+entreprise.getNumSiret()+"' size ='50'> </i></td></tr>";
			contact = (Contact)entreprise;
		}
		else
		{
			contact = (Contact)request.getAttribute("contact");
		}	
		
		pageResponse += "<tr align='center'><td align='right'><i>FirstName:</td> ";
		pageResponse += "<input type='hidden' name ='idContact' value='"+contact.getId()+"'/>";
		pageResponse += "<td><input type='text' name='firstName' value='"+contact.getFirstName()+"' size ='50'> </i></td></tr>";
		pageResponse += "<tr><td align='right'><i>LastName:</td><td><input type='text' name='lastName' value='"+contact.getLastName()+"' size ='50'> </i></td></tr>";
		pageResponse += "<tr><td><input type='text' name='email' value='"+contact.getEmail()+"' size ='50'> </i></td></tr>";

		pageResponse += "<tr><td align='right'><i>City:</td><td><input type='text' name='city' value='"+city+"' size ='50'> </i></td></tr>";
		pageResponse +="<tr><td align='right'><i>street:</td><td><input type='text' name='street' value='"+ street+"' size ='50'> </i></td></tr>";
		pageResponse +="<tr><td align='right'><i>Zip:</td><td><input type='text' name='zip' value='"+ Zip+"' size ='50'> </i></td></tr>";
		pageResponse +="<tr><td align='right'><i>Country:</td><td><input type='text' name='country' value='"+ country+"' size ='50'> </i></td></tr>";

		int i = 0;
		try{
			for(PhoneNumber phone : phones)
			{				
				pageResponse +="<tr><td align='right'><i>phone Kind:</td><td><input type='text' name='phone"+i+"' value='"+ phone.getPhoneKind()+"' size ='50'> </i></td></tr>";
				i++;
				pageResponse +="<tr><td align='right'><i>phone Number:</td><td><input type='text' name='phone"+i+"' value='"+ phone.getPhoneNumber()+"' size ='50'> </i></td></tr>";
				i++;
			}
			
		}
		catch(Exception e){}
		pageResponse +=	"<tr> <td align ='right'><input type='reset' value='Quitter'/></td>";
		pageResponse += "<td><input type='submit' value='Valider'/></td></tr></table>";
		pageResponse += "</fieldset>";
		pageResponse += "</table> ";
		pageResponse += "</form></body></html>";
		out.println(pageResponse);
	%> 
