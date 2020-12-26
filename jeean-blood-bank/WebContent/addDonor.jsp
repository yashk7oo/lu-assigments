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
<header>
<%@ include file="menu.jsp" %>
</header>

<%
        String newUser=(String)session.getAttribute("user");
       
        //redirect user to home page if already logged in
        if(newUser==null){
        	response.sendRedirect("Login.jsp");
        }
       
        
    %>
    
    <h2 style="text-align:center;color:green;"><c:out value="${message }"></c:out></h2>

<form action="blood" method="post">
   <label for="">Donor Name</label>
   <input type="text" name="donorName" required/>
   
      <label for="">Donor Age</label>
   <input type="number" name="donorAge" required/>
   
       <label for="">Donor gender</label>
   <input type="text" name="donorGender" required/>
   
       <label for="">Donor Blood Group</label>
   <input type="text" name="donorBloodGroup" required/>   
   
      <label for="">Donor Number</label>
   <input type="text" name="donorNumber"  required/>
   
      <label for="">Doctor email</label>
   <input type="text" name="donorEmail" required/> <!-- change text to checkbox -->
   
      <label for="">Date of Birth</label>
   <input type="date" name="dateOfBirth" required/>
   
   <input type="submit" value="Add" />
</form>


<p>RowsAdded:</p>
<c:out value="${rowsAdded}" />

</body>
</html>