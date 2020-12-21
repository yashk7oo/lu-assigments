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

<h2 style="text-align:center;">Student List</h2>

<table>
   <tr>
      <th>Roll Number</th>
      <th>Student name</th>
      <th>Mark Scored</th>
      </tr>
<c:forEach items="${studentList}" var="eachStudent">
      <tr>
        <td><c:out value="${eachStudent.rollNumber}"/></td>
        <td><c:out value="${eachStudent.studentName}"/></td>
        <c:if test="${eachStudent.markScored>=75 }">
        <td style="color:green">
          <c:out value="${eachStudent.markScored}"/>
        </td>
        </c:if>
         <c:if test="${eachStudent.markScored<75 }">
        <td style="color:red">
          <c:out value="${eachStudent.markScored}"/>
        </td>
        </c:if>
      </tr>
</c:forEach>
</table>
</body>
</html>