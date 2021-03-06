<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tickets</title>
</head>
<body>
<h1>Ticket Details</h1>

	 <table border="3">
	<tr>
		
		<th>Reservation Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Gender</th>
	</tr>
	<c:forEach var="passenger" items="${passengers}">
		<tr>
			<td>${reservationID }</td>
			<td>${passenger.name}</td>
			<td>${passenger.age}</td>
			<td>${passenger.gender}</td>
			</tr>
	
	</c:forEach>
	
	</table>
</body>
</html>