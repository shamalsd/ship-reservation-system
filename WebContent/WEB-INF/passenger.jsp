<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<sf:form action="savePassenger" method="post" modelAttribute="passengerBeanList">

<table>		
<c:forEach var="status" begin="1" end="${reservation.noOfSeats}" varStatus="status">
		<tr>
			<td>Schedule Id:</td>
			<td><input type="text" name="passengerList[${status.index}].scheduleID" value="${reservation.scheduleID}" readonly="readonly" /></td>
		</tr>

		<tr>
			<td>Name:</td>
			<td><input type="text" name="passengerList[${status.index}].name" /></td>
		</tr>
		<tr>
			<td>Age:</td>
			<td><input type="text" name="passengerList[${status.index}].age" /></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td><input type="text" name="passengerList[${status.index}].gender"/></td>
			
		</tr>
		</c:forEach>
			
		<tr><td><input type="submit" value="Proceed"/></td></tr>
		</table>
</sf:form>
</body>
</html>