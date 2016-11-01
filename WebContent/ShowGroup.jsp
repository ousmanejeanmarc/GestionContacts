
<%@page import="entities.ContactGroup"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="services.ContactGroupService"%>
<%
	
		List<ContactGroup>groups  =(List<ContactGroup>)request.getAttribute("groupes");
		String pageResponse = "<html><head><title>Groupe</title></head><body>";
		if(groups !=null)
		{
			pageResponse += "<fieldset><table>";	
			for(ContactGroup grp: groups)
			{
				pageResponse += "<tr align='center'><td align='right'><i>"+grp.getGroupName()+"</td> ";				
			}
			pageResponse += "</fieldset></table>";	
			pageResponse += "</body></html>";	
			out.println(pageResponse);
			
		}
		else
		{
			out.println("vide");
		}
		
	%> 
