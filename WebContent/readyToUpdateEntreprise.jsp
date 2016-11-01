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




		String pageResponse = "<html><head><title>Mise à jour Contact</title></head><body>";
		pageResponse += "<form method='post' action='UpdateEntreprise'>";
		pageResponse +="<fieldset><legend>Modifier les inforations de l'entreprise</legend>";
		pageResponse += "<table>";
		Entreprise entreprise = null;
		
		Address address = (Address)request.getAttribute("address");
		String city = (address==null)?"":address.getCity();
		String street = (address==null)?"":address.getStreet();
		String Zip =  (address==null)?"":address.getZip();
		String country = (address==null)?"": address.getCountry();
		
		List<PhoneNumber> phones =(List<PhoneNumber>) request.getAttribute("phones");

		entreprise = (Entreprise)request.getAttribute("entreprise");
	
		pageResponse += "<tr align='center'><td align='right'><i>FirstName:</td> ";
		pageResponse += "<input type='hidden' name ='idEntreprise' value='"+entreprise.getId()+"'/>";
		pageResponse += "<td><input type='text' name='firstName' value='"+entreprise.getNumSiret()+"' size ='50'> </i></td></tr>";
		pageResponse += "<td><input type='text' name='firstName' value='"+entreprise.getFirstName()+"' size ='50'> </i></td></tr>";
		pageResponse += "<tr><td align='right'><i>Email:</td><td><input type='text' name='email' value='"+entreprise.getEmail()+"' size ='50'> </i></td></tr>";

		pageResponse += "<tr><td align='right'><i>City:</td><td><input type='text' name='city' value='"+city+"' size ='50'> </i></td></tr>";
		pageResponse +="<tr><td align='right'><i>street:</td><td><input type='text' name='street' value='"+ street+"' size ='50'> </i></td></tr>";
		pageResponse +="<tr><td align='right'><i>Zip:</td><td><input type='text' name='zip' value='"+ Zip+"' size ='50'> </i></td></tr>";
		pageResponse +="<tr><td align='right'><i>Country:</td><td><input type='text' name='country' value='"+ country+"' size ='50'> </i></td></tr>";

		int i = 0;
		try{
			for(PhoneNumber phone : phones)
			{				
				pageResponse +="<tr><td align='right'><i>phone Kind:</td><td><input type='text' name='"+phone.getPhoneNumber()+"' value='"+ phone.getPhoneKind()+"' size ='50'> </i></td></tr>";
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
