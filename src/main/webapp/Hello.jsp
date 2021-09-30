<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello ${uname}, Welcome to Delhi Electricity Board</h1>
<br><br><br><br>
<center>
<a href="HomeServlet?action=logout">SignOut</a>
<table border="3px">
<tr>
<th>
Customer_id
</th>
<th>
Customer_name
</th>
</tr>
<c:forEach var="c" items="${cList}">
<tr>
<td><a href="HomeServlet?action=search&cid=${c.cid}"> ${c.cid}</a></td>
<td>${c.cname}</td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>