<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href="style.css" rel="stylesheet" type="text/css">
<title>Register a New User</title>
<script type="text/javascript">
	function check(form) {
		if (document.reg.password.value != document.reg.rePassword.value) {
			alert("The passwords do not match. Please check again!!");
			document.reg.rePassword.value = ""
			document.reg.rePassword.focus()
			return false
		}

		return true
	}
</script>
</head>
<a href="login.jsp" class = "logout">Back to Login</a>
<center>
<body>
	<h2 style="padding-bottom: 70px;">Register User</h2>
	<form name=reg method="post" onSubmit="return check(this)" action="RegisterServlet">
	<%
    if(null!=request.getAttribute("message"))
    {
    	out.println("<h4>");
        out.println(request.getAttribute("message"));
        out.println("</h4>");
    }
%>
		<table cellspacing="5" cellpadding="3">
			<tr>
				<td>USERNAME:</td>
				<td><input type="text" name="userName" required="true"/></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><input type="password" name="password" required="true"/></td>
			</tr>
			<tr>
				<td>RE-PASSWORD:</td>
				<td><input type="password" name="rePassword" required="true"/></td>
			</tr>
			<tr>
				<td>FIRSTNAME:</td>
				<td><input type="text" name="fName" required="true"/></td>
			</tr>
			<tr>
				<td>LASTNAME:</td>
				<td><input type="text" name="lName" required="true"/></td>
			</tr>
			<tr>
				<td>AGE:</td>
				<td><input type="text" name="age" required="true"/></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>Male<input type="radio" name="gender" value="male" checked="true">
					Female<input type="radio" name="gender" value="female" /></td>
			</tr>
			<tr>
				<td>ADDRESS:</td>
				<td><input type="text" name="adderess" required="true"/></td>
			</tr>
			<tr>
				<td>PHONE:</td>
				<td><input type="text" name="phone" required="true"/></td>
			</tr>
			<tr>
				<td>BRANCH:</td>
				<td><select name="accbranch" required="true">
						<option value="kansas">Kansas</option>
						<option value="dallas">Dallas</option>
						<option value="colorado">Colorado</option>
						<option value="newyork">NewYork</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /> <INPUT TYPE=RESET
					VALUE="CLEAR"></td>
			</tr>
		</table>
	</form>
</body>
</center>
</html>