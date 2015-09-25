<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href="style.css" rel="stylesheet" type="text/css">
<title>Create a New Account</title>
</head>

<body>

	<a href="index.jsp" class="logout">Back To Index</a>
<center style="padding-top: 200px;">
	<h2>Create Account</h2>
	<form name=acc method="post" action="CreateAccountServlet">

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
				<td>CUSTOMER ID:</td>
				<td><select name="customerid" required="true">
				<%
		ArrayList list = (ArrayList) request.getAttribute("activeCustomerlist");

		// print the information about every category of the list
		for(int i = 0; i < list.size(); i++) {
			int id= (Integer)list.get(i);%>
			<option value=<%=id %>><%=id %></option>	
		<%} %> 
				</select></td> 
			</tr>
			<tr>
				<td>ACCOUNT TYPE:</td>
				<td><select name="acctype" required="true">
						<option value="checking">Checking</option>
						<option value="saving">Saving</option>
				</select></td>
			</tr>
			<tr>
				<td>ACCOUNT BALANCE:</td>
				<td><input type="text" name="acctbalance" required="true"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /> <INPUT TYPE=RESET
					VALUE="CLEAR"></td>
			</tr>
		</table>
	</form>
	</center>
</body>

</html>