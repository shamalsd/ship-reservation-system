<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Schedule</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form action="addingSchedule" method="post">
<table>
        <tr>
			<td>Ship Id:</td>
			<td><input type="text" name="shipID"/></td>
		</tr>
		<tr>
			<td>Route Id:</td>
			<td><input type="text" name="routeID"/></td>
		</tr>
		<tr>
			<td>StartDate:</td>
			<td><input type="text" name="startDate"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Add Schedule"/></td>
		</tr>
		</table>
</form>
</body>
</html>