<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ships</title>
</head>
<body>
<h1>Ship Details</h1>
	
	<table border="3">
	<tr>
		<th>Ship Id</th>
		<th>Ship Name</th>
		<th>Seating Capacity</th>
		<th>Reservation Capacity</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="ship" items="${ships}">
		<tr>
			<td>${ship.shipID }</td>
			<td>${ship.shipName }</td>
			<td>${ship.seatingCapacity}</td>
			<td>${ship.reservationCapacity }</td>
			<td><a href="modify?shipID=${ship.shipID }&&shipName=${ship.shipName}&&seatingCapacity=${ship.seatingCapacity}&&reservationCapacity=${ship.reservationCapacity }"><input type="submit" value="Edit"/></a></td>
			<td><a href="delete?shipID=${ship.shipID}"><input type="submit" value="Delete"/></a></td>
		</tr>
	
	</c:forEach>
	
	</table>
</body>
</html>