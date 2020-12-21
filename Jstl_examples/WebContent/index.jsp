<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP with JSTL</title>
</head>
<body>

<c:set value="Horizon College" var="heading" scope="page"/>

<h1 style="text-align:center;"><c:out value="${heading }"/></h1>

<form action="student" method="get">
   <div>
     <label for="">Branch</label>
     <select name="dept">
       <option value="csc">Computer Science</option>
       <option value="ece">Electronics</option>
       </select>   
   </div>
   <div>
   <input type="submit" value="Search"/>
   </div>
</form>
</body>
</html>