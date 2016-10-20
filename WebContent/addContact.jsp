<%@page import="java.util.List, entities.ContactGroup, services.ContactGroupService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajout d'un contact</title>
</head>
<body>

 <form method="post" action="newContact">
 	<table >
 	    <tr>
 		 <td>
		 	<fieldset>
		 		<legend>Type</legend>
		 			<input id="contact" type="radio" name="type" value="Contact" size="25" checked>Contact 
		 		    <input id="entreprise" type="radio" name="type" value="Entreprise" size="25">Entreprise
		 		   	
	 		</fieldset>
	 	</td>
	 	<td></td><td></td>
	   </tr>
	 </table>
	 <table>
		 <tr>
		 	<td>
				<fieldset>
						<legend>Informations personnelles</legend>
							<i> Numéro Siret: <input type="long" name="numSiret" size="25"></i><br/>
							<i>FirstName: <input type="text" name="firstName" size="25"> </i><br/>	
							<i>LastName: <input type="text" name="lastName" size="25"> </i><br/>
							<i>Email: <input type="text" name="email" size="25"> </i>		
				</fieldset>
			</td>
			<td>
				<fieldset>
			<legend>Adresse</legend>
				<i>Street: <input type="text" name="street" size="25"> </i><br/>
				<i>City: <input type="text" name="city" size="25"> </i><br/>
				<i>Zip: <input type="text" name="zip" size="25"> </i><br/>
				<i>Country: <input type=text name="country" size="25"> </i>	
		</fieldset>
			</td>
	 </tr>
	 </table>
	<table>
		 <tr>
			<td><fieldset>
				<legend>PhoneNumber</legend>
					
				<!-- <i>Phone Kind: <input type="text" name="phoneKind" size="25"> </i><br/>
					<i>Phone Number: <input type="text" name="phoneNumber" size="25"> </i><br/>
				 -->
					<label><input type="checkbox" id="cboxmobile" name="phoneKindMobile" value="phoneKindMobile">Mobile</label>
					<input type="text" name="phoneNumberMobile" size="25" maxlength="15"> 
					<br>
					<label><input type="checkbox" id="cboxbureaux" name="phoneKindBureaux" value="phoneKindBureaux">Bureaux</label>
					<input type="text" name="phoneNumberBureaux" size="25" maxlength="15"> 
					<br>
					<label><input type="checkbox" id="cboxmaison" name="phoneKindMaison" value="phoneKindMaison">Maison</label>
						<input type="text" name="phoneNumberMaison" size="25" maxlength="15"> 
					<br>
					<label><input type="checkbox" id="cboxPhoneautre" name="phoneKindautre" value="phoneKindautre">Autre</label>
						<input type="text" name="phoneNumberAutre" size="25" maxlength="15"> 
					<br>
					
			</fieldset></td>
			<td>
				<fieldset>
					<legend>Groups</legend>
					<%
					ContactGroupService serviceG=new ContactGroupService();
					List<ContactGroup> list=serviceG.initialiseGroup();
				
					for(int i=0;i<list.size();i++){%>
						<label><input type="checkbox"  name="groupes<%=i%>"
								 value="<%=list.get(i).getIdContactGroup()%>"><%=list.get(i).getGroupName()%></label><br>
					<%}%>
					
					<label>Nouveau <input type="text" name="newGroup" id="newGroup"/></label>
					
					
					
					
					
					<!-- <i>Group Name: <input type="text" name="group" size="25"> </i>
					
					<label><input type="checkbox" id="cboxAmi" name="gamis" value="Amis"> Ami</label><br>
					<input type="hidden" name="Amis" value="1"/>
					<label><input type="checkbox" id="cboxFamille" name="gfamille" value="Famille">Famille</label><br>
					<label><input type="checkbox" id="cboxCollegue" name="gcollegue" value="Collegue"> Collègue</label><br>
					-->
					
					
			</fieldset></td>
		</tr>
	</table>	 
	 	
	 	
	
		
	
						

		

	<tr align="center">
				</br><td align="right">	<input class="button" type ="submit" value="Submit"/>
					    <input class="button" type ="reset" value="Reset"/>
			    </td>			
		</tr>
 	</table>
 </form>
</body>
</html>