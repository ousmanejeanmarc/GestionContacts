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
 	<table align ="center" >
 
 	<div align="center">
 			<input id="contact" type="radio" name="choice" value="Contact" size="25" checked>Contact 
 		    <input id="entreprise" type="radio" name="choice" value="Entreprise" size="25">Entreprise<br>
 	</div>

 		<tr>
				<th colspan="2"><h2 align="center">Entreprise</h2></th>
		</tr>
		<tr align="center">
				<td align="right"><i>Numero Siret: <input type="long" name="numSiret" size="25"> </i></td>
		</tr>
 		<tr>
				<th colspan="2"><h2 align="center">Ajouter un nouveau contact</h2></th>
		</tr>
		<tr align="center">
				<td align="right"><i>FirstName: <input type="text" name="firstName" size="25"> </i></td>
		</tr>
		<tr align="center">
				<td align="right"><i>LastName: <input type="text" name="lastName" size="25"> </i></td>
		</tr>
		<tr align="center">
				<td align="right"><i>Email: <input type="text" name="email" size="25"> </i></td>
		</tr>
		
		<th><h2>Adresse</h2></th>
		
		<tr align="center">
				<td align="right"><i>Street: <input type="text" name="street" size="25"> </i></td>
		</tr>
		<tr align="center">
				<td align="right"><i>City: <input type="text" name="city" size="25"> </i></td>
		</tr>
		
		<tr align="center">
				<td align="right"><i>Zip: <input type="text" name="zip" size="25"> </i></td>
		</tr>
		<tr align="center">
				<td align="right"><i>Country: <input type=text name="country" size="25"> </i></td>
		</tr>

		
				<th><h2>PhoneNumber</h2></th>
		
		<tr align="center">
				<td align="right"><i>Phone Kind: <input type="text" name="phoneKind" size="25"> </i></td>
		</tr>
		<tr align="center">
				<td align="right"><i>Phone Number: <input type="text" name="phoneNumber" size="25"> </i></td>
		</tr>					
		
						<th><h2>Group</h2></th>
		
		<tr align="center">
				<td align="right"><i>Group Name: <input type="text" name="group" size="25"> </i></td>
		</tr>
		<tr align="center">
				</br><td align="right">	<input class="button" type ="submit" value="Submit"/>
					    <input class="button" type ="reset" value="Reset"/>
			    </td>
				
				
		</tr>
 	</table>
 </form>
</body>
</html>