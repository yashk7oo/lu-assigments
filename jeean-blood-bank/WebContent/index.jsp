<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="text-align:center;color:red;"><c:out value="${message }"></c:out></h2>
<ul>
	
	<li><a href="Login.jsp">Login </a></li> 
 	<li><a href="blood">View Donor </a></li>
</ul>
</body>
</html>