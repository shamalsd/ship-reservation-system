<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Ship</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form action="addingShip" method="post">
<table>
		<tr>
			<td>Ship Name:</td>
			<td><input type="text" name="shipName"/></td>
		</tr>
		<tr>
			<td>Seating Capacity:</td>
			<td><input type="text" name="seatingCapacity"/></td>
		</tr>
		<tr>
			<td>Reservation Capacity:</td>
			<td><input type="text" name="reservationCapacity"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Add Ship"/></td>
		</tr>
		</table>
</form>
</body>
</html>