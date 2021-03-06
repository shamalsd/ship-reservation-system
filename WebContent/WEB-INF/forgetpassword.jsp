<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form action="numberValidation" method="post">
<table>
		<tr>
			<td>UserID:</td>
			<td><input type="text" name="userID" /></td>
		</tr>
		<tr>
			<td>Mobile Number:</td>
			<td><input type="text" name="mobileNo"/></td>
		</tr>

		<tr>
			<td><input type="submit" value="Validate"/></td>
		</tr>
		</table>
</form>
</body>
</html>