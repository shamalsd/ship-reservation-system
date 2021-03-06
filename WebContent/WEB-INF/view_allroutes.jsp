<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Routes</title>
</head>
<body>
<h1>Route Details</h1>
	
	<table border="3">
	<tr>
		<th>Route Id</th>
		<th>Source</th>
		<th>Destination</th>
		<th>Travel Duration</th>
		<th>Fare</th>
		
	</tr>
	<c:forEach var="route" items="${routes}">
		<tr>
			<td>${route.routeID }</td>
			<td>${route.source }</td>
			<td>${route.destination}</td>
			<td>${route.travelDuration}</td>
			<td>${route.fare}</td>
			
		</tr>
	
	</c:forEach>
	
	</table>
</body>
</html>