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

<h1 style="text-align:center;text-transform: uppercase;">Donors List</h1>
<table style="text-align: center;text-transform: uppercase;">
   <tr>
      <th style="text-align:center">Name</th>
      <th style="text-align:center">Gender</th>
      <th style="text-align:center">City</th>
      <th style="text-align:center">Mobile Number</th>
      <th style="text-align:center">Age</th>
      <th style="text-align:center">Blood Group</th>
      <th style="text-align:center">Last Donate Date</th>
    </tr>
<c:forEach var="eachDonor" items="${donor}" >
         
           <tr>
        <td><c:out value="${eachDonor.name}"/></td>
        <td><c:out value="${eachDonor.gender}"/></td>
         <td><c:out value="${eachDonor.city}"/></td>
          <td><c:out value="${eachDonor.phoneNumber}"/></td>
           <td><c:out value="${eachDonor.age}"/></td>
           <td><c:out value="${eachDonor.bloodGroup}"/></td>
           <td><c:out value="${eachDonor.dateOfLastDonation}"/></td>    
          </tr>
      </c:forEach>
</table>

</body>
</html>