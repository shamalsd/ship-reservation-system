<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form action="viewScheduleBySd" method="post">
<table>
		<tr>
			<td>Enter Source:</td>
			<td><input type="text" name="source"/></td>
		</tr>
		<tr>
			<td>Enter Destination:</td>
			<td><input type="text" name="destination"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="View Schedule"/></td>
		</tr>
		</table>
</form>
</body>
</html>