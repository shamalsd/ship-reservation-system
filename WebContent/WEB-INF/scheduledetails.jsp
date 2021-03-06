<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedules</title>
</head>
<body>
<h1>Schedule Details</h1>
	
	<table border="3">
	<tr>
		
		<th>Schedule Id:</th>
		<th>Ship Id:</th>
		<th>Route Id:</th>
		<th>Start Date:</th>
	</tr>
	<c:forEach var="schedule" items="${schedules}">
		<tr>
			<td>${schedule.scheduleID}</td>
			<td>${schedule.shipID}</td>
			<td>${schedule.routeID}</td>
			<td>${schedule.startDate}</td>
			
		</tr>
	
	</c:forEach>
	
	</table>
</body>
</html>