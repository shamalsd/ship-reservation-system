<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<%
    response.setHeader("Cache-Control", "private,no-store,no-cache");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
</head>
<body>
<form action="booked" method="post">
<table>
	<tr>
			<td>CreditCard Number:</td>
			<td><input type="text" name="creditCardNumber" /></td>
		</tr>
		<tr>
			<td>Valid From:</td>
			<td><input type="text" name="validFrom" /></td>
		</tr>
		<tr>
			<td>Valid To:</td>
			<td><input type="text" name="validTo" /></td>
		</tr>
		<tr>
			<td>User Id:</td>
			<td><input type="text" name="userID" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Pay"/></td>
		</tr>
		</table>
</form>
</body>
</html>