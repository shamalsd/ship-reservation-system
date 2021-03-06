<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Ship</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form action="saveModify" method="post">
<table>
	<tr>
			<td>Ship ID:</td>
			<td><input type="text" name="shipID" value="${ship.shipID}" readonly="readonly"/></td>
		</tr>
		<tr>
			<td>Ship Name:</td>
			<td><input type="text" name="shipName" value="${ship.shipName}" readonly="readonly"/></td>
		</tr>
		<tr>
			<td>Seating Capacity:</td>
			<td><input type="text" name="seatingCapacity" value="${ship.seatingCapacity}"/></td>
		</tr>
		<tr>
			<td>Reservation Capacity:</td>
			<td><input type="text" name="reservationCapacity" value="${ship.reservationCapacity}"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Modify Ship"/></td>
		</tr>
		</table>
</form>
</body>
</html>