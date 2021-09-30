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
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Nothing+You+Could+Do" rel="stylesheet">
	<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<link rel="stylesheet" href="css/magnific-popup.css">
	<link rel="stylesheet" href="css/aos.css">
	<link rel="stylesheet" href="css/ionicons.min.css">
	<link rel="stylesheet" href="css/bootstrap-datepicker.css">
	<link rel="stylesheet" href="css/jquery.timepicker.css">
	<link rel="stylesheet" href="css/flaticon.css">
	<link rel="stylesheet" href="css/icomoon.css">
	<link rel="stylesheet" href="css/style.css">
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
			<a class="navbar-brand" href="HomeServlet?action=index"><span class="flaticon-pizza-1 mr-1"></span>Pizza<br><small>Delicous</small></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="HomeServlet?action=index" class="nav-link">Home</a></li>
					<li class="nav-item"><a href="HomeServlet?action=menu" class="nav-link">Menu</a></li>
					<li class="nav-item active"><a href="HomeServlet?action=services" class="nav-link">Services</a></li>
					<li class="nav-item"><a href="HomeServlet?action=about" class="nav-link">About</a></li>
					<li class="nav-item"><a href="HomeServlet?action=contact" class="nav-link">Contact</a></li>
					<li class="nav-item">
					<% if(session.getAttribute("user")!= null){ %>
					<li class="nav-item">
						<div class="nav-link dropdown">
						  <span>${user}</span>
						  <div class="dropdown-content">
						  	  <a href="LoginServlet?action=details" class="nav-link">Profile</a>
							  <a href="LoginServlet?action=logout" class="nav-link">Logout</a>
						  </div>
						</div>
					</li>
					<li class="nav-item"><a href="HomeServlet?action=cartView" class="nav-link"><i class="fa fa-shopping-cart"></i></a></li>
					<% }else{%>
						<li class="nav-item"><a href="login.jsp" class="nav-link">Login</a></li>
					<%} %>
				</ul>
			</div>
		</div>
	</nav>

	<section class="home-slider owl-carousel img" style="background-image: url(images/bg_1.jpg);">
		<div class="slider-item" style="background-image: url(images/bg_3.jpg);">
			<div class="overlay"></div>
			<div class="container">
				<div class="row slider-text justify-content-center align-items-center">
					<div class="col-md-7 col-sm-12 text-center ftco-animate">
						<h1 class="mb-3 mt-5 bread">Services</h1>
						<p class="breadcrumbs"><span class="mr-2"><a href="index.jsp">Home</a></span> <span>Services</span></p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="ftco-section ftco-services">
		<div class="overlay"></div>
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3">
				<div class="col-md-7 heading-section ftco-animate text-center">
					<h2 class="mb-4">Our Services</h2>
					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 ftco-animate">
					<div class="media d-block text-center block-6 services">
						<div class="icon d-flex justify-content-center align-items-center mb-5">
							<span class="flaticon-diet"></span>
						</div>
						<div class="media-body">
							<h3 class="heading">Healthy Foods</h3>
							<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 ftco-animate">
					<div class="media d-block text-center block-6 services">
						<div class="icon d-flex justify-content-center align-items-center mb-5">
							<span class="flaticon-bicycle"></span>
						</div>
						<div class="media-body">
							<h3 class="heading">Fastest Delivery</h3>
							<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 ftco-animate">
					<div class="media d-block text-center block-6 services">
						<div class="icon d-flex justify-content-center align-items-center mb-5"><span class="flaticon-pizza-1"></span></div>
						<div class="media-body">
							<h3 class="heading">Original Recipes</h3>
							<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3">
				<div class="col-md-7 heading-section ftco-animate text-center">
					<h2 class="mb-4">Hot Meals</h2>
					<p class="flip"><span class="deg1"></span><span class="deg2"></span><span class="deg3"></span></p>
					<p class="mt-5">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
				</div>
			</div>
			<div class="row">
			<%int a=0; %>
				<c:forEach items="${pizzas}" var="pizza">
					<%if(a==4) break;%>
					<div class="col-md-3 text-center ftco-animate">
					<div class="menu-wrap">
						<a href="#" class="menu-img img mb-4" style="background-image: url(images/dish/${pizza.image});"></a>
						<div class="text">
							<h3>${pizza.name}</h3>
							<p>${pizza.description}</p>
							<p class="price"><span>Rs. ${pizza.price}</span></p>
							<p><a href="HomeServlet?action=cart&source=services&foodid=${pizza.foodId}" class="btn btn-white btn-outline-white">Add to cart</a></p>
						</div>
					</div>
				</div>
				<%a++; %>
				</c:forEach>
			</div>
		</div>
	</section>
	<footer class="ftco-footer ftco-section img">
		<div class="overlay"></div>
		<div class="container">
			<div class="row mb-5">
				<div class="col-lg-3 col-md-6 mb-5 mb-md-5">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">About Us</h2>
						<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
						<ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
							<li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
							<li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
							<li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 mb-5 mb-md-5">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">Recent Blog</h2>
						<div class="block-21 mb-4 d-flex">
							<a class="blog-img mr-4" style="background-image: url(images/image_1.jpg);"></a>
							<div class="text">
								<h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about</a></h3>
								<div class="meta">
									<div><a href="#"><span class="icon-calendar"></span> Sept 15, 2018</a></div>
									<div><a href="#"><span class="icon-person"></span> Admin</a></div>
									<div><a href="#"><span class="icon-chat"></span> 19</a></div>
								</div>
							</div>
						</div>
						<div class="block-21 mb-4 d-flex">
							<a class="blog-img mr-4" style="background-image: url(images/image_2.jpg);"></a>
							<div class="text">
								<h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about</a></h3>
								<div class="meta">
									<div><a href="#"><span class="icon-calendar"></span> Sept 15, 2018</a></div>
									<div><a href="#"><span class="icon-person"></span> Admin</a></div>
									<div><a href="#"><span class="icon-chat"></span> 19</a></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-6 mb-5 mb-md-5">
					<div class="ftco-footer-widget mb-4 ml-md-4">
						<h2 class="ftco-heading-2">Services</h2>
						<ul class="list-unstyled">
							<li><a href="#" class="py-2 d-block">Cooked</a></li>
							<li><a href="#" class="py-2 d-block">Deliver</a></li>
							<li><a href="#" class="py-2 d-block">Quality Foods</a></li>
							<li><a href="#" class="py-2 d-block">Mixed</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 mb-5 mb-md-5">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">Have a Questions?</h2>
						<div class="block-23 mb-3">
							<ul>
								<li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
								<li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
								<li><a href="#"><span class="icon icon-envelope"></span><span class="text"><span class="__cf_email__" data-cfemail="620b0c040d221b0d1710060d0f030b0c4c010d0f">[email&#160;protected]</span></span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 text-center">
					<p>
						Copyright &copy;
					</p>
				</div>
			</div>
		</div>
	</footer>

	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" />
		</svg>
	</div>
	<c:if test = "${fn:contains(message, 'Message')}">
	alert("${message}");
	<%session.setAttribute("message", "null"); %>
</c:if>
	<script src="js/jquery.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/jquery-migrate-3.0.1.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/popper.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/bootstrap.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/jquery.easing.1.3.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/jquery.waypoints.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/jquery.stellar.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/owl.carousel.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/jquery.magnific-popup.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/aos.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/jquery.animateNumber.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/bootstrap-datepicker.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/jquery.timepicker.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/scrollax.min.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="js/main.js" type="bed3a32e25829a1c5acc523b-text/javascript"></script>
	<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/95c75768/cloudflare-static/rocket-loader.min.js" data-cf-settings="bed3a32e25829a1c5acc523b-|49" defer=""></script>
	</body>
	</html>