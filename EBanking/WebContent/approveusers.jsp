<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href="style.css" rel="stylesheet" type="text/css">
<title>Approve Users</title>
<style>
table, th, td{
    border: 1px solid;
 border-collapse: collapse;
}
</style>
</head>
<body>
<a href="index.jsp" class="logout">Back To Index</a>
<center style="padding-top: 200px;">
<form name=appruser method="post" action="ApproveUsersServlet" >

	<table>	
		<tr>
				<td>SELECT</td>
				<td>CUSTOMER ID</td>
			</tr>
		<%
		ArrayList list = (ArrayList) request.getAttribute("customerlist");

		// print the information about every category of the list
		for(int i = 0; i < list.size(); i++) {
			int id= (Integer)list.get(i);%>
			<tr><td><input type="checkbox" name="customerid" value=<%=id %>></td> 
			<td><%=id%></td></tr>		
		<%} %> 
	</table>
	<br/>
	<input type="submit" value="Submit" /> <INPUT TYPE=RESET
					VALUE="CLEAR">
</form>
</center>
</body>
</html>