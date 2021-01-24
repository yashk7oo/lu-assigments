<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Donor</title>
</head>
<body>
<header>
<%@include file="menu.html" %>
</header>

<form:form action="delete" method="post">

<div>
    <label for="">Phone Number</label>
    <form:input path="phoneNumber"/>

</div>


<div>
   <input type="submit" value="Delete" >
</div>
</form:form>
	

</body>
</html>