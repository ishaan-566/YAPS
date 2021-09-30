<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
</head>

<body>
	<div class="card" style="min-width:50%;margin:20px;width: 75%">
		<form class="card-body" action="AdminUpdateServlet">
			<h1 class="card-title">Update ${update}</h1>
			<div class="form-group">
		    	<label>ID</label>
				<input type="text" name="id" class="form-control" value="${id}" readonly>
		  	</div>
			<div class="form-group">
		    	<c:forEach items="${columns}" var="column">
		    		<label>${column.key}</label>
					<input type="text" name="${column.key}" class="form-control" value="${column.value}">
				</c:forEach>
		  	</div>
		  	<c:if test="${fn:contains(update, 'dish')}">
		  		<div class="form-group">
		    		<label>Description</label>
		    		<textarea rows="" cols="" class="form-control" name="Description">${Description}</textarea>
		  		</div>
		  	</c:if>
		  	<c:choose>
		  		<c:when test="${fn:contains(update, 'dish')}">
		  			<button type="submit" class="btn btn-info" name="action" value="update-dish">Submit Information</button>
		  		</c:when>
		  		<c:when test="${fn:contains(update, 'store')}">
		  			<button type="submit" class="btn btn-info" name="action" value="update-store">Submit Information</button>
		  		</c:when>
		  	</c:choose>
		</form>
	</div>
</body>
</html>
