<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Donor By City Name</title>
</head>
<body>
<header>
<%@include file="menu.html" %>
</header>

<form:form action="campName" method="post">

<div>
    <label for="">Camp Name</label>
    <form:input path="campName"/>

</div>


<div>
   <input type="submit" value="Find" >
</div>
</form:form>
	

</body>
</html>