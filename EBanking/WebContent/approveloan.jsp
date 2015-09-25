<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href="style.css" rel="stylesheet" type="text/css">
<title>Approve Loan</title>
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
<form name=apprloan method="post" action="ApproveLoanServlet" >

	<table>	
		<tr>
				<td>SELECT</td>
				<td>CUSTOMER ID</td>
				<td>LOAN TYPE</td>
				<td>LOAN AMOUNT</td>
			</tr>
		<%
		ArrayList customerlist = (ArrayList) request.getAttribute("loancustomerlist");
		ArrayList loantypelist = (ArrayList) request.getAttribute("loantypelist");
		ArrayList loanamountlist = (ArrayList) request.getAttribute("loanamountlist");
		ArrayList loanaccountnumberlist = (ArrayList) request.getAttribute("loanaccountnumberlist");
		

		// print the information about every category of the list
		for(int i = 0; i < customerlist.size(); i++) {
			int id= (Integer)customerlist.get(i);
			String type= (String)loantypelist.get(i);
			double amount= (Double)loanamountlist.get(i);
			int acctnumber= (Integer)loanaccountnumberlist.get(i);%>
			<tr><td><input type="checkbox" name="loanacctnum" value=<%=acctnumber %>></td> 
			<td><%=id%></td>
			<td><%=type%></td>
			<td><%=amount%></td></tr>		
		<%} %> 
	</table>
	<br/>
	<input type="submit" value="Submit" /> <INPUT TYPE=RESET
					VALUE="CLEAR">
</form>
</center>
</body>
</html>