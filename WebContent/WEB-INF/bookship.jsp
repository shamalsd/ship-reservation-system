<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ship Booking</title>
</head>
<body>
<h1>Ship Details</h1>
	
	<table border="3">
	<tr>
		
		<th>Route Id</th>
		<th>Source</th>
		<th>Destination</th>
		<th>Schedule Id</th>
		<th>Ship Id</th>
		<th>journey Date</th>
		<th>Fare</th>
		<th>No of Seats</th>
		<th>Book</th>
		
	</tr>
	<c:forEach var="schedule" items="${schedules}">
		<tr>
			<td>${schedule.routeID }</td>
			<td>${source}</td>
			<td>${destination }</td>
			<td>${schedule.scheduleID}</td>
			<td>${schedule.shipID}</td>
			<td>${schedule.startDate}</td>
			<td>${route.fare}</td>
			<td>${seats}</td>
			<td><a href="saveBooking?scheduleID=${schedule.scheduleID}&&userID=${userID}&&bookingDate=${schedule.startDate}&&journeyDate=${schedule.startDate}&&noOfSeats=${seats}&&totalFare=${route.fare}">
			<input type="submit" value="Book"/></a></td>
			
			
			
		</tr>
	
	</c:forEach>
	
	</table>
</body>
</html>