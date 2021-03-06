<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Registration</title>
</head>
<body>
<div style="background-color: lightblue">
<h1>Register Here</h1>
<table>
	<tr>
		<td><img src="${pageContext.request.contextPath}/resources/srslogo.png" width="150" height="150"/></td>
		<td width="200%" align="center"> <h1>Ship Reservation System</h1></td>
	</tr>
	
</table>
</div>
<hr>

<form action="addUser" method="post" >
	<table>
		<tr>
			<td>*First Name:</td>
			<td><input type="text" name="firstName" required/></td>
		</tr>
		<tr>
			<td>*Last Name:</td>
			<td><input type="text" name="lastName" required/></td>
		</tr>
		<tr>
			<td>*DOB:</td>
			<td><input type="date" name="dateOfBirth" /></td>
		</tr>
		  <tr>
             <td>*Gender</td>
                  <td>
                      <input type="radio" name="gender" value="M"/>Male
                      <input type="radio" name="gender" value="F"/>Female
                   </td>
           </tr>
           <tr>
			<td>*Street:</td>
			<td><input type="text" name="street" required/></td>
		</tr>
		<tr>
			<td>*Location:</td>
			<td><input type="text" name="location" required/></td>
		</tr>
		<tr>
			<td>*City:</td>
			<td><input type="text" name="city" required/></td>
		</tr>
		<tr>
			<td>*State:</td>
			<td><input type="text" name="state" required/></td>
		</tr>
		<tr>
			<td>*Pincode:</td>
			<td><input type="text" name="pincode" required/></td>
		</tr>
		<tr>
			<td>*Mobile No:</td>
			<td><input type="text" name="mobileNo" required/></td>
		</tr>
		<tr>
			<td>*Email Id:</td>
			<td><input type="text" name="emailId" required/></td>
		</tr>
		<tr>
			<td>*Password:</td>
			<td><input type="password" name="password" required/></td>
		</tr>
		<tr>
			<td><input type="submit" name="action" value="Register"/></td>
		</tr>
	</table>
</form>
</body>
</html>