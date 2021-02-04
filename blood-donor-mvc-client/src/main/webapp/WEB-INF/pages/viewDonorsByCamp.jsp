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
      <th style="text-align:center"> Donor Name</th>
      <th style="text-align:center">Camp Name</th>
      <th style="text-align:center">Camp Id</th>
      <th style="text-align:center">Camp City</th>
      <th style="text-align:center">Mobile Number</th>
    </tr>
<c:forEach var="eachDonor" items="${donor}" >
         
           <tr>
        <td><c:out value="${eachDonor.donorName}"/></td>
        <td><c:out value="${eachDonor.campName}"/></td>
         <td><c:out value="${eachDonor.campId}"/></td>
          <td><c:out value="${eachDonor.campCity}"/></td>
           <td><c:out value="${eachDonor.phoneNumber}"/></td>    
          </tr>
      </c:forEach>
</table>

</body>
</html>