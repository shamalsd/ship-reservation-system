<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Route</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form action="addingRoute" method="post">
<table>
		<tr>
			<td>Source:</td>
			<td><input type="text" name="source"/></td>
		</tr>
		<tr>
			<td>Destination:</td>
			<td><input type="text" name="destination"/></td>
		</tr>
		<tr>
			<td>Travel Duration:</td>
			<td><input type="text" name="travelDuration"/></td>
		</tr>
		<tr>
			<td>Fare:</td>
			<td><input type="text" name="fare"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Add Route"/></td>
		</tr>
		</table>
</form>
</body>
</html>