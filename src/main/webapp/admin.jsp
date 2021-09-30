<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>YAPS</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/flaticon.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/style.css">	
	<link rel="stylesheet" href="css/aos.css">
	<style>
		.dropdown {
		  position: relative;
		  display: inline-block;
		}
		
		.dropdown-content {
		  display: none;
		  padding: 0 2%;
		  color: black;
		  position: absolute;
		  background-color: #121618;
  		  min-width: 200px;
  		  box-shadow: 1px 1px 1px 1px;
		}
		.dropdown:hover .dropdown-content {
  		  display: block;
		}
	}
	</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"><span class="flaticon-pizza-1 mr-1"></span>Pizza<br><small>Admin</small></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
				<i class="fa fa-bars" aria-hidden="true"></i> Menu
			</button>
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="admin.jsp" class="nav-link">Home</a></li>
					<li class="nav-item">
					<% if(session.getAttribute("user")!= null){ %>
						<div class="nav-link dropdown">
						  <span>${user}</span>
						  <div class="dropdown-content">
							  <a href="LoginServlet?action=logout" class="nav-link">Logout</a>
						  </div>
						</div>
						
					<% }else{%>
						<a href="login.jsp" class="nav-link">login
						<%} %>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br>
	<div class="card-columns" style="padding: 10px;color: black">
	  <div class="card">
	    <img class="card-img-top" src="images/icons/admin.png" alt="Admin image" style="width:100%">
	    <div class="card-body">
	      <h4 class="card-title" style="color: black">Add/Remove Admin User</h4>
	      <p class="card-text">Use this to add or delete any Admin</p>
	      <a href="AdminServlet?action=user" class="btn btn-primary">Proceed</a>
	    </div>
	  </div>
	  
	  <div class="card">
	    <img class="card-img-top" src="images/icons/store.jpg" alt="Admin image" style="width:100%">
	    <div class="card-body">
	      <h4 class="card-title" style="color: black">Add/Remove Store</h4>
	      <p class="card-text">Use this to add or delete any Stores</p>
	      <a href="AdminServlet?action=store" class="btn btn-primary">Proceed</a>
	    </div>
	  </div>
	
	<div class="card">
	    <img class="card-img-top" src="images/icons/store.jpg" alt="Admin image" style="width:100%">
	    <div class="card-body">
	      <h4 class="card-title" style="color: black">Update Store Details</h4>
	      <p class="card-text">Use this to update store details</p>
	      <a href="AdminServlet?action=update-store" class="btn btn-primary">Proceed</a>
	    </div>
	  </div>
	  
	  <div class="card">
	    <img class="card-img-top" src="images/icons/food.jpg" alt="Admin image" style="width:100%">
	    <div class="card-body">
	      <h4 class="card-title" style="color: black">Add/Remove Dish</h4>
	      <p class="card-text">Use this to add or delete any Dish</p>
	      <a href="AdminServlet?action=dish" class="btn btn-primary">Proceed</a>
	    </div>
	  </div>
	  <div class="card">
	    <img class="card-img-top" src="images/icons/food.jpg" alt="Admin image" style="width:100%">
	    <div class="card-body">
	      <h4 class="card-title" style="color: black">Update Dish Details</h4>
	      <p class="card-text">Use this to update any dish details</p>
	      <a href="AdminServlet?action=update-dish" class="btn btn-primary">Proceed</a>
	    </div>
	  </div>
	  
	</div>
	
	<script src="js/jquery.min.js" type="19a7e03d728585efc2420360-text/javascript"></script>
	<script src="js/popper.min.js" type="19a7e03d728585efc2420360-text/javascript"></script>
	<script src="js/bootstrap.min.js" type="19a7e03d728585efc2420360-text/javascript"></script>
	<script src="js/main.js" type="19a7e03d728585efc2420360-text/javascript"></script><script src="js/aos.js" type="0bc516995cf4dbb9daafb72e-text/javascript"></script>
	<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/95c75768/cloudflare-static/rocket-loader.min.js" data-cf-settings="19a7e03d728585efc2420360-|49" defer=""></script>
	<script type="text/javascript">
	<% 
		if(request.getAttribute("message") != null){
	%>
			alert("${message}")
	<%	}%>
	</script>
</body>
</html>