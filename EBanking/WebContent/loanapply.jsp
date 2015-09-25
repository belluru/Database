<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK href="style.css" rel="stylesheet" type="text/css">
<title>Apply Loan</title>
</head>
<body>
<a href="customerindex.jsp" class="logout">Back To Index</a>
<center style="padding-top: 200px;">
<h2>Apply For a Loan</h2>
<form name=loan method="post" action="CreateLoanAccountServlet">

<table cellspacing="5" cellpadding="3">
<tr>
				<td>LOAN TYPE:</td>
				<td><select name="loantype" required="true">
						<option value="personal">Personal</option>
						<option value="housing">Housing</option>
						<option value="vehicle">Vehicle</option>
				</select></td>
			</tr>
			<tr>
				<td>LOAN AMOUNT:</td>
				<td><input type="text" name="loanamount" required="true"/></td>
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