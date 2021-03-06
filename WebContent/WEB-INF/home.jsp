<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<!-- <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script> -->
<title>Home</title>
</head>

<body background="${pageContext.request.contextPath}/resources/Boat.jpg">
<table >
	<tr>
		<td><img src="${pageContext.request.contextPath}/resources/srslogo.png" width="150" height="150"/></td>
		<td width="200%" align="center"><h1 style="font-size: 500%;color: rgba(26, 155, 230, 0.966)"><b>Ship Reservation System</b></h1></td>
	</tr>
</table>



<table >
<tr ><td colspan="2" align="right"><b><a href="#about">About Us</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="#contact">Contact Us</a>&nbsp;&nbsp;</b></td></tr>

<tr>
<td></td>
</tr>
<tr>
<td width="100%" style="height: 750px;text-align: start;"><p style="font-size: 30px;font-weight: bold">BNB Sea Travels Ltd provides sea travel services to users across the Globe.
This application SRS@Ship Reservation System is developed by BNB Sea Travels where Users can reserve ship tickets and manage their reservations.</p></td>
	<td width="100%">
		<table   style="font-size: 22px">
<form method="post" action="login" align="right">
	<div class="container" >
		<tr><td align="left"><b>Login</b></td></tr>

	
		<tr>
    <td ><input size="40" type="text" class="formm-control" placeholder="Username" name="userID" required ></td>
</tr>

<br>

<tr>
    <td><input size="40" type="password" placeholder="Password" name="password" required></td>
    </tr>
    <br>
     <tr>
	<td>Customer <input type="radio" name="userType" value="C" checked="checked"/>
		Administrator <input type="radio" name="userType" value="A"/>
	</tr>
    <tr>    
    <td>
    <label> 
      <input type="checkbox" name="remember">Remember me on this computer

    </label>
<button type="submit">Login</button></td>
</tr>
<tr style="background-color:darkgrey"><td align="center">Forgot your Password?<a href="forgetPassword">Click here to see it</a></td></tr>


  </div>	
</form>
</table>
<p align="center"><a href="register">New User?</a>Register here</p>
</td>

</tr>
<tr style="color: white">
    <td><a id="about">About Us:</a>
    <ul>
    		<li>Beauty</li>
    		<li>Bharti</li>
    		<li>Nikita</li>
    		
    	</ul>
    </td>
    <td><a id="contact">Contact</a>
    	<ul>
    		<li>Beauty Kumari</li>
    		<li>beautysingh2708@gmail.com</li>
    		
    	</ul>
    </td>
    
</tr>
</table>

</body>

</html>