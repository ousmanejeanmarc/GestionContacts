<%@page import="services.EntrepriseService"%>
<%@page import="services.IEntrepriseService"%>
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
 <% IEntrepriseService entrepriseService = new EntrepriseService();
 	List <Entreprise>entreprises = entrepriseService.getAllEntreprise();
 	//List<Entreprise>entreprises = contactService.getAllEntreprise();
 	%>
 	<h1>Les contacts :</h1>
 	<%
	for(Entreprise entreprise:entreprises){
	%>
	
		<tr><td>
		<input type="checkbox" name="id" value="<%=entreprise.getId()%>"/>
		<label><%=entreprise.getFirstName()%></label></td>
		 <td><%=entreprise.getNumSiret()%></td>
		 
		 </tr>
	<% }%>
 <tr><td colspan="3" align="center"><input type="submit" value="Modifier"><input type="Reset" value="Annuler"></td></tr>
</table>
</form>
</body>
</html>