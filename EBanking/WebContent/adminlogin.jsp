<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Login</title>
<LINK href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<center>
<h2 class="pageheading">EBanking Administrator Login</h2>
<form name=F1 method="post" action="AdminLoginServlet" >
<%
    if(null!=request.getAttribute("errorMessage"))
    {
    	out.println("<h4>");
        out.println(request.getAttribute("errorMessage"));
        out.println("</h4>");
    }
%>
	<table cellspacing="10" cellpadding="3">	
		<tr><td>ADMIN ID:</td> <td><input type="text" name="aid"></td></tr>
		<tr><td>PASSWORD:</td> <td><input type="password" name="pwd"></td></tr>
		<tr><td></td><td><input type="submit" value="Submit"/>
		<INPUT TYPE=RESET VALUE="CLEAR"></td></tr>
		<tr><td></td><td><a href="login.jsp">Login Page</a></td></tr>
	</table>
</form>
<center>
</body>
</html>