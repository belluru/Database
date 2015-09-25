<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href="style.css" rel="stylesheet" type="text/css">
<title>Welcome Page</title>
</head>
<body onload="clearMessage();">
<form action="ActionRedirectServlet" method="POST">
<%
    if(null!=request.getAttribute("message"))
    {
    	out.println("<h4 id = ");
    	out.println("\"mess\">");
        out.println(request.getAttribute("message"));
        out.println("</h4>");
    }
%>
<a href="LogOutServlet" class = "logout">Logout</a>
<br/>
<center style="padding-top: 200px;">
<h2>Welcome <%= session.getAttribute("adminid") %></h2>
<br/>
<table cellspacing="5" cellpadding="3">
			<tr>
				<td>ACTION:</td>
				<td><select name="action" required="true">
						<option value="approve">Approve Customers</option>
						<option value="create">Create Account</option>
						<option value="approveloan">Approve Loan Account</option>
				</select></td>
			</tr>
			<tr><td></td><td><input type="submit" value="Submit"/>
		<INPUT TYPE=RESET VALUE="CLEAR"></td></tr>
</table>
</center>
</form>
</body>
</html>