<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form action="viewBookingDetails" method="post">
<table>
	<tr>
			<td>User ID:</td>
			<td><input type="text" name="userID" /></td>
		</tr>
		<tr>
			<td>Enter Source:</td>
			<td><input type="text" name="source"/></td>
		</tr>
		<tr>
			<td>Enter Destination:</td>
			<td><input type="text" name="destination"/></td>
		</tr>
		
		<tr>
			<td>No. of Seats:</td>
			<td><input type="text" name="seats"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="View Ships"/></td>
		</tr>
		</table>
</form>
</body>
</html>