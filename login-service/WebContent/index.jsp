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



<form action="validate" method="post">
   <label for="">Enter username</label>
   <input type="text" name="userName" required/>
   
      <label for="">Password</label>
   <input type="password" name="password" required/>
   
         <label for="">Role</label>
   <input type="text" name="role" required/>
   
   
      
   
   <input type="submit" value="Add" />
</form>




</body>
</html>