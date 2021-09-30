<%@page import="com.services.CartService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*, com.beans.Food, com.DAO.LoginDao" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <title>Bootstrap shopping cart</title>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta name="robots" content="noindex, nofollow">
  <meta name="googlebot" content="noindex, nofollow">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <script
    type="text/javascript"
    src="/js/lib/dummy.js"
    
  ></script>

    <link rel="stylesheet" type="text/css" href="/css/result-light.css">

      <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
      <script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.slim.min.js"></script>
      <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

  <style id="compiled-css" type="text/css">
body {
  background: #eecda3;
  background: -webkit-linear-gradient(to right, #eecda3, #ef629f);
  background: linear-gradient(to right, #eecda3, #ef629f);
  min-height: 100vh;
}
.dropdown {
		  position: relative;
		  display: inline-block;
		}
		
		.dropdown-content {
		  display: none;
		  padding: 0 2%;
		  z-index: 1;
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
					<li class="nav-item active"><a href="HomeServlet?action=index" class="nav-link">Home</a></li>
					<li class="nav-item"><a href="HomeServlet?action=menu" class="nav-link">Menu</a></li>
					<li class="nav-item"><a href="HomeServlet?action=services" class="nav-link">Services</a></li>
					<li class="nav-item"><a href="HomeServlet?action=about" class="nav-link">About</a></li>
					<li class="nav-item"><a href="HomeServlet?action=contact" class="nav-link">Contact</a></li>
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
    <div class="px-4 px-lg-0">
  <div class="pb-5">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

          <!-- Shopping cart table -->
          <div class="table-responsive">
            <table class="table">
              <thead>
                <tr>
                  <th scope="col" class="border-0 bg-light">
                    <div class="p-2 px-3 text-uppercase">Product</div>
                  </th>
                  <th scope="col" class="border-0 bg-light">
                    <div class="py-2 text-uppercase">Price</div>
                  </th>
                  <th scope="col" class="border-0 bg-light">
                    <div class="py-2 text-uppercase">Quantity</div>
                  </th>
                  <th scope="col" class="border-0 bg-light">
                    <div class="py-2 text-uppercase">Remove</div>
                  </th>
                </tr>
              </thead>
              <tbody>
              <%
              CartService cs = new CartService();
              LinkedHashMap<Food, Integer> cart = cs.getCart(session.getAttribute("user").toString());
			  int quantity = cart.size();
			  int price = 0;
              for (Map.Entry<Food ,Integer> entry : cart.entrySet()){
            	  price += entry.getValue() * entry.getKey().getPrice();
              %>
              	<tr>
                  <th scope="row" class="border-0">
                    <div class="p-2">
                    <%Food f = entry.getKey();%>
                      <img src="images/dish/<%out.println(f.getImage()); %>" alt="" width="70" class="img-fluid rounded shadow-sm">
                      <div class="ml-3 d-inline-block align-middle">
                        <h5 class="mb-0"> <sapn class="text-dark d-inline-block align-middle"><%out.println(f.getName()); %></span></h5>
                        <span class="text-muted font-weight-normal font-italic d-block">Type: <%out.println(f.getType()); %></span>
                      </div>
                    </div>
                  </th>
                  <td class="border-0 align-middle"><strong><%out.println(f.getPrice()); %></strong></td>
                  <td class="border-0 align-middle">
                  	<a href="HomeServlet?action=update&source=cart-minus&foodid=<%out.println(f.getFoodId());%>" class="text-dark">
                  		<i class="fa fa-minus" aria-hidden="true"></i>
                  	</a>&nbsp
                  	<strong><%out.println(entry.getValue());%></strong>&nbsp
                  		<a href="HomeServlet?action=update&source=cart-plus&foodid=<%out.println(f.getFoodId());%>" class="text-dark">
                  		<i class="fa fa-plus" aria-hidden="true"></i>
                  	</a>
                  </td>
                  <td class="border-0 align-middle">
                  	<a href="HomeServlet?action=delete&source=cart&foodid=<%out.println(f.getFoodId());%>" class="text-dark">
                  		<i class="fa fa-trash"></i>
                  	</a>
                  </td>
                </tr>
              <%} %>
              </tbody>
            </table>
          </div>
          <!-- End -->
        </div>
      </div>

      <div class="row py-5 p-4 bg-white rounded shadow-sm">
        <div class="col-lg-6">
          <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Coupon code</div>
          <div class="p-4">
            <p class="font-italic mb-4">If you have a coupon code, please enter it in the box below</p>
            <div class="input-group mb-4 border rounded-pill p-2">
              <input type="text" placeholder="Apply coupon" aria-describedby="button-addon3" class="form-control border-0">
              <div class="input-group-append border-0">
                <button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Apply coupon</button>
              </div>
            </div>
          </div>
          <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Instructions for seller</div>
          <div class="p-4">
            <p class="font-italic mb-4">If you have some information for the seller you can leave them in the box below</p>
            <textarea name="" cols="30" rows="2" class="form-control"></textarea>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary </div>
          <div class="p-4">
            <p class="font-italic mb-4">Shipping and additional costs are calculated based on values you have entered.</p>
            <ul class="list-unstyled mb-4">
              <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>Rs. <%out.println(price); %></strong></li>
              <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Shipping and handling</strong><strong>Rs. 30</strong></li>
              <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                <h5 class="font-weight-bold">Rs. <%request.setAttribute("pri", price+30);%>${pri }</h5>
              </li>
            </ul><a href="HomeServlet?action=checkout&price=${pri }" class="btn btn-dark rounded-pill py-2 btn-block">Procceed to checkout</a>
          </div>
        </div>
      </div>

    </div>
  </div>
</div>
</body>
</html>
