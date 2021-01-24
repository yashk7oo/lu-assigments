<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<header>
<%@include file="menu.html" %>
</header>
<div class="container">
 <div align="center">
        <h2>Donor Registration for Camp</h2>
        
        <form:form action="register" method="post" class="form-horizontal" >
        
          <div class="form-group row">
            <label class="col-sm-2 col-form-label">Phone Number:</label>
            <div class="col-sm-7">
            <form:input path="phoneNumber"  class="form-control"/>
            </div>
             </div>
             
             <div class="form-group row">
             <label class="col-sm-2 col-form-label">Camp Id:</label>
              <div class="col-sm-7">
            <form:input path="campId" value="" class="form-control"/>
             </div>
             </div>
            
            <div class="form-group row">
             <label class="col-sm-2 col-form-label">Camp Name:</label>
             <div class="col-sm-7">
            <form:input path="campName" class="form-control"/>
            </div>
             </div>
            
            
            <div class="form-group row">
            <label class="col-sm-2 col-form-label">Camp City:</label>
            <div class="col-sm-7">
            <form:input path="campCity" class="form-control"/>
            </div>
             </div>
            
            
            <div class="form-group row">
            <label class="col-sm-2 col-form-label">Donor Name:</label>
            <div class="col-sm-7">
            <form:input type="date" path="donorName" class="form-control"/>
            </div>
             </div>
            
            
           
    
    
            
             
             
             
             
             
            
           
            
            
                 
            <input type="submit" value="Registration">
        </form:form>
    </div>


</div>








</body>
</html>





