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
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" href="css/aos.css">
	<style>
		#box{
			padding:10px;	
		}
		
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
		* {
		  box-sizing: border-box;
		}
		
		#myInput {
		  width: 100%;
		  font-size: 16px;
		  padding: 12px 20px 12px 40px;
		  border: 1px solid #ddd;
		  margin-bottom: 12px;
		}
		
		#myTable {
		  border-collapse: collapse;
		  width: 100%;
		  border: 1px solid #ddd;
		  font-size: 18px;
		}
		
		#myTable th, #myTable td {
		  text-align: left;
		  padding: 12px;
		}
		
		#myTable tr {
		  border-bottom: 1px solid #ddd;
		}
		
		#myTable tr.header {
		  background-color: #FAC564;
}
	</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="HomeServlet?action=index"><span class="flaticon-pizza-1 mr-1"></span>Pizza<br><small>Admin</small></a>
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
	<section id="box">
		<h2>${add}</h2>
		<label style="color: white">Search</label>
		<input type="text" id="myInput" onkeyup="myFunction()" title="Type in a name" >
		<form action='AdminServlet'>
			<table id="myTable">
				<tr class="header">
					<c:forEach items="${columns}" var="column">
						<th>${column.key}</th>
			    	</c:forEach>
			    	<th>Action</th>
			  	</tr>
			  	<c:forEach items="${records}" var="record">
			  		<tr>
			  			${record}
			  			<td class="nav-item">
			  				<c:if test = "${fn:contains(add, 'user')}">
			  					<c:if test = "${fn:contains(record.loginStatus, 'false')}">
									<a href="AdminServlet?action=delete-${add}&id=${record.userId}" class="btn btn-primary">Delete</a>
								</c:if>
							</c:if>
							<c:choose>
								<c:when test="${fn:contains(add, 'dish')}">
							    	<a href="AdminServlet?action=delete-${add}&id=${record.foodId}" class="btn btn-primary">Delete</a>
							    </c:when>
							    <c:when test="${fn:contains(add, 'store')}">
							    	<a href="AdminServlet?action=delete-${add}&id=${record.storeId}" class="btn btn-primary">Delete</a>
							    </c:when>
							</c:choose>
			  			</td>
			  		</tr>
			  	</c:forEach>
			  	<tr>
			  		<c:forEach items="${columns}" var="column">
			  			<td><input type="${column.value}" name="${column.key}" required></td>
			    	</c:forEach>
			    	<td>
			    	<c:choose>
			    		<c:when test = "${fn:contains(add, 'user')}">
			    			<button type="submit" class="btn btn-primary" name="action" value="add-${add}">Add</button>
			    		</c:when>
			    		<c:otherwise>
				    		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
				    		<div class="modal fade" id="myModal" role="dialog">
								<div class="modal-dialog">
							    	<div class="modal-content">
							        	<div class="modal-header">
							        		<strong class="modal-title">Modal Header</strong>
							          		<button type="button" class="close" data-dismiss="modal">&times;</button>
							        	</div>
							        	<div class="modal-body">
								        	<c:forEach items="${others}" var="other">
								        		<label>${other.key}</label>
				  								<input type="${other.value}" name="${other.key}" required style="border:1px solid black">
				    						</c:forEach>
				    						<c:if test = "${fn:contains(add, 'dish')}">
				    							<label>Description :</label>
								          		<textarea name="Description" maxlength="100" style="border:1px solid black;"></textarea>
					    					</c:if>						          		
							        	</div>
							        	<div class="modal-footer">
							        		<c:choose>
							        			<c:when test="${fn:contains(add, 'dish')}">
							        				<button type="submit" class="btn btn-default" name="action" value="add-dish">Submit</button>
							        			</c:when>
							        			<c:when test="${fn:contains(add, 'store')}">
							        				<button type="submit" class="btn btn-default" name="action" value="add-store">Submit</button>
							        			</c:when>
							        		</c:choose>
							        	</div>
							      	</div>
							    </div>
							</div>
			    		</c:otherwise>
			    	</c:choose>
			    	</td>
			  	</tr>
			</table>
		</form>
	</section>
	<script src="js/jquery.min.js" type="19a7e03d728585efc2420360-text/javascript"></script>
	<script src="js/popper.min.js" type="19a7e03d728585efc2420360-text/javascript"></script>
	<script src="js/bootstrap.min.js" type="19a7e03d728585efc2420360-text/javascript"></script>
	<script src="js/main.js" type="19a7e03d728585efc2420360-text/javascript"></script>
	<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/95c75768/cloudflare-static/rocket-loader.min.js" data-cf-settings="19a7e03d728585efc2420360-|49" defer=""></script>
	<script src="js/aos.js" type="0bc516995cf4dbb9daafb72e-text/javascript"></script>
	<script>
	<% 
	if(request.getAttribute("message") != null){
%>
		alert("${message}")
<%	}%>
		function myFunction() {
		  var input, filter, table, tr, td, i, txtValue;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[0];
		    if (td) {
		      txtValue = td.textContent || td.innerText;
		      if (txtValue.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }       
		  }
		}
</script>

</body>
</html>