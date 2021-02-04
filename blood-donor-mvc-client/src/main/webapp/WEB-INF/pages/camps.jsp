<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  padding: 5px;
  margin-left:auto;
  margin-right:auto;
}
table {
  border-spacing: 15px;
}
</style>
</head>
<body>
<header>
<%@include file="menu.html" %>
</header>

<h1 style="text-align:center;text-transform: uppercase;">Donors List</h1>
<table style="text-align: center;text-transform: uppercase;">
   <tr>
      
      <th style="text-align:center">Camp Name</th>
     
    </tr>
<c:forEach var="eachDonor" items="${donor}" >
         
           <tr>
        
        <td><c:out value="${eachDonor}"/></td>
             
          </tr>
      </c:forEach>
</table>

</body>
</html>