<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href="style.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
<center>
<h2 class="pageheading">EBanking Customer Login</h2>

<form name=F1 method="post" action="LoginServlet" >
<%
    if(null!=request.getAttribute("errorMessage"))
    {
    	out.println("<h4>");
        out.println(request.getAttribute("errorMessage"));
        out.println("</h4>");
    }
%>
	<table cellspacing="10" cellpadding="3">	
		<tr><td>USER NAME:</td> <td><input type="text" name="uName"></td></tr>
		<tr><td>PASSWORD:</td> <td><input type="password" name="pwd"></td></tr>
		<tr><td></td><td><input type="submit" value="Submit"/>
		<INPUT TYPE=RESET VALUE="CLEAR"></td></tr>
		<tr><td></td><td><a href="register.jsp">New User? Register</a></td></tr>
		<tr><td></td><td><a href="adminlogin.jsp">admin</a></td></tr>
	</table>
</form>
</center>
</body>
</html>