<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Signup</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" href="css/flaticon.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="HomeServlet?action=index"><span class="flaticon-pizza-1 mr-1"></span>Pizza<br><small>Delicous</small></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="HomeServlet?action=index" class="nav-link">Home</a></li>
					<li class="nav-item"><a href="HomeServlet?action=menu" class="nav-link">Menu</a></li>
					<li class="nav-item"><a href="HomeServlet?action=services" class="nav-link">Services</a></li>
					<li class="nav-item"><a href="blog.jsp" class="nav-link">Blog</a></li>
					<li class="nav-item"><a href="HomeServlet?action=about" class="nav-link">About</a></li>
					<li class="nav-item"><a href="HomeServlet?action=contact" class="nav-link">Contact</a></li>
					<li class="nav-item">
					<% if(session.getAttribute("user")!= null){ %>
						<div class="nav-link dropdown">
						  <span>${user}</span>
						  <div class="dropdown-content">
						  	  <a href="LoginServlet?action=details" class="nav-link">Profile</a>
							  <a href="LoginServlet?action=logout" class="nav-link">Logout</a>
						  </div>
						</div>
						
					<% }else{%>
						<a href="login.jsp" class="nav-link active">login
						<%} %>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action='LoginServlet'>
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>

					<span class="login100-form-title p-b-34 p-t-27">
						sign up
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Enter EmailId">
						<input class="input100" type="text" name="username" placeholder="EmailId">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="pass" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Comfirm password">
						<input class="input100" type="password" name="confirm" placeholder="Confirm Password">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" name='action' value='signup'>
							SignUP
						</button>
					</div>

					<div class="text-center p-t-90">
						<a class="txt1" href="login.jsp">
							Already have an Account Login here!
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<script src="js/login-main.js"></script>
	<script type="text/javascript">
		<c:set var = "message" value="${message}"/>
		<c:if test = "${fn:contains(message, 'Error')}">
			alert("${message}")
		</c:if>
	</script>

</body>
</html>