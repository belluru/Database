<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href="style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<style>
table, th, td{
    border: 1px solid;
 border-collapse: collapse;
}
</style>
</head>
<body>
<form name=custdetails method="post">
<a href="customerindex.jsp" class="logout">Back To Index</a>
<center style="padding-top: 200px;">
	<table>
	
	<tr>
		<td><label for="customerid">Customer ID</label></td>
		<td><label for="firstname">Firstname</label></td>
		<td><label for="lastname">Lastname</label></td> 
		<td><label for="address">Address</label></td>
		<td><label for="phone">Phone</label></td> 
		<td><label for="branch">Branch</label></td>
		<td><label for="loanaccount_number">LoanAccount Number</label></td> 
		<td><label for="loan_type">Loan Type</label></td> 
		<td><label for="loan_amount">Loan Amount</label></td>
		<td><label for="loan_status">Loan Status</label></td> 
	</tr>
		<%
		ArrayList custid = (ArrayList) request.getAttribute("custid");
		ArrayList firstname = (ArrayList) request.getAttribute("firstname");
		ArrayList lastname = (ArrayList) request.getAttribute("lastname");
		ArrayList address = (ArrayList) request.getAttribute("address");
		ArrayList phone = (ArrayList) request.getAttribute("phone");
		ArrayList branch = (ArrayList) request.getAttribute("branch");
		ArrayList loanacctnumber = (ArrayList) request.getAttribute("loanacctnumber");
		ArrayList loantype = (ArrayList) request.getAttribute("loantype");
		ArrayList loanamount = (ArrayList) request.getAttribute("loanamount");
		ArrayList loanstatus = (ArrayList) request.getAttribute("loanstatus");
		for(int i = 0; i < custid.size(); i++) {
		// print the information about every category of the list
			int id = (Integer)custid.get(i);
			String fname = (String)firstname.get(i);
			String lname = (String)lastname.get(i);
			String add = (String)address.get(i);
			String pn = (String)phone.get(i);
			String br = (String)branch.get(i);
			int lacn = (Integer)loanacctnumber.get(i);
			String ltype = (String)loantype.get(i);
			double lamt = (Double)loanamount.get(i);
			String ls = (String)loanstatus.get(i);%>
		<tr>
			<td><%=id%></td>
			<td><%=fname%></td>
			<td><%=lname%></td>
			<td><%=add%></td>
			<td><%=pn%></td>
			<td><%=br%></td>
			<td><%=lacn%></td>
			<td><%=ltype%></td>
			<td><%=lamt%></td>
			<td><%=ls%></td>
		</tr>
		<%} %> 
	</table>
	</center>
	<br/>
</form>

</body>
</html>