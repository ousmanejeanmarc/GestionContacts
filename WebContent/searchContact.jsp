<%@page import="java.util.ArrayList, entities.Contact"%>
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="searcheContact" method="post">
<table COLS="2" align="left">
<tr>
	<td align="right">
		<fieldset>
			<legend>Recherché par</legend>
			
			<i>FirstName: <input type="text" name="firstName" size="25"> </i><br/>
			<i>LastName: <input type="text" name="lastName" size="25"> </i><br/>
			<i>Email: <input type="text" name="email" size="25"> </i><br/>
			<!--  <i>Phone Number: <input type="text" name="phoneNumber" size="25"> </i><br/> -->
		</fieldset>
	</td>
</tr>
<tr>
	<td align="right">
		<fieldset>
			<legend>Recherché par Adresse</legend>
			<i>Street: <input type="long" name="street" size="25"> </i> <br/>
			<i>City: <input type="text" name="city" size="25"> </i><br/>
			<i>Zip: <input type="long" name="zip" size="25"> </i> <br/>
			<i>country: <input type="text" name="country" size="25"> </i>
		</fieldset>
	</td>
</tr>

	
</tr>
<tr>
	<td align="left"><input class="button" type ="button" value="Retour" onClick="history.back()"/></td>
	<td align="right"> 
		 <input class="button" type ="Submit" value="Submit"/>
		 <input class="button" type ="reset" value="Reset"/>
	</td>
</tr>
</table>
<table align="center" border="1">
	<th>FirstName</th>
	<th>LastName</th>
	<th>Email</th>
	<th>address</th>
<!-- mettre le resultat de la recherche dans cette table -->
<% 
	ArrayList<Contact> result=null;

	if(request.getAttribute("result")!=null){
		
		result=(ArrayList<Contact>)request.getAttribute("result");
		
		if(result.size()!=0){
			for(int i=0;i<result.size();i++){
				out.print("<tr><td>");
						out.print(result.get(i).getFirstName());
						//out.print(result.get(i).getNumSiret());
				out.print("</td><td>");
						out.print(result.get(i).getLastName());
				out.print("</td><td>");
						out.print(result.get(i).getEmail());
				out.print("</td><td>");
					out.print(result.get(i).getAddress().getStreet()+"\n"
							+result.get(i).getAddress().getZip()+"\n"
							+result.get(i).getAddress().getCity());	
				out.print("</td></tr>");
			}
		}else {
			out.println("Aucun contact ne correspond à votre recherche !!!");
		}
		
	}
%>





</table>

</form>
<script type="text/javascript">
function retourMenu(){
	RequestDispatcher rd=request.getRequestDispatcher("accueil.jsp");
	rd.forward(request, response);	
}
</script>
</body>
</html>