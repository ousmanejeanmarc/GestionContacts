<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="design/home.css">
</head>
<body>

<div id="entete">
<table>

<tr>
	<td colspan="3"><h3>Your Book<h3></td>
	<td colspan="3"><h5>Contact<h5></td>
	<td><input type="button" id="newContact" value="new" onclick="" /></td>
	<td><input type="button" id="showContact" value ="show" onclick="" /></td>
	<td><input type="button" id="updateContact" value ="update" onclick="" /></td>
	<td><input type="button" id="searchContact" value ="search" onclick="" /></td>
	<td><input type="button" id="deleteContact" value ="delete" onclick="" /></td>
	<td colspan="3"><h5>Entreprise<h5></td>
	<td><input type="button" id="newEntreprise" value="new" onclick="" /></td>
	<td><input type="button" id="showEntreprise" value ="show" onclick="" /></td>
	<td><input type="button" id="updateEntreprise" value ="update" onclick="" /></td>
	<td><input type="button" id="searchEntreprise" value ="search" onclick="" /></td>
	<td><input type="button" id="deleteEntreprise" value ="delete" onclick="" /></td>
	<td colspan="3"><h5>Group<h5></td>
	<td><input type="button" id="newGroup" value="new" onclick="" /></td>
	<td><input type="button" id="showGroup" value ="show" onclick="" /></td>
		<td><input type="button" id="updateGroup" value ="update" onclick="" /></td>
	<td><input type="button" id="deleteGroup" value ="delete" onclick="" /></td>
</tr>
</table>
</div>

 <!-- 
	<center>
	 <fieldset label="Contact">
	    <a href="addContact.jsp">Creer un nouveau contact </a></br></br>
	    <a href="removeContact.jsp">Supprimer un contact </a></br></br>
	    <a href="updateContact.jsp">Modifier un contact </a></br></br>
	    <a href="searchContact.jsp">Rechercher </a></br>
	    
	   	 <form method="GET" action="ShowGroup"><input type="submit" value="Voir tous les groupes"> <br/></form>
		 <form method="POST" action="UpdateGroup">
		
		 <label for="groupName">nom du groupe: </label> <input type="text" name="groupName" id="groupName" size="25"> <br/>	 
		 <label for="idGroup">id du groupe: </label> <input type="text" name="idGroup" id="idGroup" size="25"><br/>
		  <input type="submit" value="Mettre à jour ce groupe">  <br/>
		 </form>
		 </fieldset> 
	   </fieldset> 
	    <fieldset label="Groupe">
	    <form method="POST" action="DeleteGroup">
	    <label for="idGroup">id du groupe: </label> <input type="text" name="idGroup" id="idGroup" size="25"> <br/>
	    <input type="submit" value="Supprimer tous les groupes"></form>

		 </fieldset> 
    </center>

 -->
    
</body>
</html>