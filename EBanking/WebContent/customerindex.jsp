<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href="style.css" rel="stylesheet" type="text/css">
<title>Customer Action page</title>
</head>
<body>
<%
    if(null!=request.getAttribute("message"))
    {
    	out.println("<h4>");
        out.println(request.getAttribute("message"));
        out.println("</h4>");
    }
%>
<a href="LogOutServlet" class = "logout">Logout</a>
<br/>
<form action="CustomerActionRedirectServlet" method="POST">
<center style="padding-top: 200px;">
<table cellspacing="5" cellpadding="3">
			<tr>
				<td>ACTION:</td>
				<td><select name="action" required="true">
						<option value="applyloan">Apply for Loan</option>
						<option value="details">View Loan Details</option>
				</select></td>
			</tr>
			<tr><td></td><td><input type="submit" value="Submit"/>
		<INPUT TYPE=RESET VALUE="CLEAR"></td></tr>
</table>
</center>
</form>
</body>
</html>