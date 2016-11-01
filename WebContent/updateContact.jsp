<%@page import="services.ContactService"%>
<%@page import="services.IContactService"%>
<%@page import="java.util.List"%>
<%@page import="entities.Contact"%>
<%@page import="entities.Entreprise"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
<form method="post" action="UpdateContact">
 <table>
 <% IContactService contactService = new ContactService();
 	List <Contact>contacts = contactService.getAllContact();
 	//List<Entreprise>entreprises = contactService.getAllEntreprise();
 	%>
 	<h1>Les contacts :</h1>
 	<%
	for(Contact contact:contacts){
	%>
	
		<tr><td>
		<input type="checkbox" name="id" value="<%=contact.getId()%>"/>
		<label><%=contact.getFirstName()%></label></td><td><%=contact.getLastName()%></td>
		 <td><%=contact.getEmail()%></td>
		 
		 </tr>
	<% }%>
 <tr><td colspan="3" align="center"><input type="submit" value="Modifier"><input type="Reset" value="Annuler"></td></tr>
</table>
</form>
</body>
</html>