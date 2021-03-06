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
	</tr>
	<c:forEach var="ship" items="${ships}">
		<tr>
			<td>${ship.shipID }</td>
			<td>${ship.shipName }</td>
			<td>${ship.seatingCapacity }</td>
			<td>${ship.reservationCapacity }</td>
			
		</tr>
	
	</c:forEach>
	
	</table>
</body>
</html>