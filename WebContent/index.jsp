<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="design/design.css">
</head>
<body>

<form method="post" action="LoginServlet" id="form"  onsubmit="return check(this)">

	<table align="center" id="connect">
			
			<th align="left"><h3 class="bold">Stay Connected!</h3></th>
			
			<tr>
				<td><label for="name">Login:</label></td><td><i> <input type="text" id="name" name="name" size="25"> </i></td>
			</tr>
			<tr>
				<td><label for="password">Password	:</label></td><td><i> <input type="password" id="password" name="password" size="25"> </i></td>
			</tr>
			<tr align="center">
			<td></td>
				<td colspan=2>	<input class="button" type ="submit" value="Submit"/>
				     <input class="button" type ="reset" value="Reset"/>
				</td>
				
			</tr>
	</table>
</form>
  <script type='text/javascript'>
function check(form)
{

	var login = form.elements['name'].value
	var passwd = fomr.elements['password'].value
	var submit = true;
	if(login=="")
	{
		form.elements['name'].style ="border-color:red";
		submit = false
	}
	
	if(passwd=="")
	{
		form.elements['password'].style ="border-color:red";
		submit = false
	}
	return submit;
}
</script>
</body>
</html>