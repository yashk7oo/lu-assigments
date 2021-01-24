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
        <h2>Add Donor</h2>
        
        <form:form action="submit" method="post" class="form-horizontal" >
        
          <div class="form-group row">
            <label class="col-sm-2 col-form-label">Full name:</label>
            <div class="col-sm-7">
            <form:input path="name"  class="form-control"/>
            </div>
             </div>
             
             <div class="form-group row">
             <label class="col-sm-2 col-form-label">Gender:</label>
              <div class="col-sm-7">
            <form:input path="gender"  class="form-control"/>
             </div>
             </div>
            
            <div class="form-group row">
             <label class="col-sm-2 col-form-label">City:</label>
             <div class="col-sm-7">
            <form:input path="city" class="form-control"/>
            </div>
             </div>
            
            
            <div class="form-group row">
            <label class="col-sm-2 col-form-label">MobileNumber:</label>
            <div class="col-sm-7">
            <form:input path="phoneNumber" class="form-control"/>
            </div>
             </div>
             
             <div class="form-group row">
            <label class="col-sm-2 col-form-label">Date Of Last Donation(yyyy-mm-dd):</label>
            <div class="col-sm-7">
            <form:input path="dateOfLastDonation" class="form-control"/>
            </div>
             </div>
            
            
           
            
            
            <div class="form-group row">
        <label for="" class="col-sm-2 col-form-label">Blood Group</label>
    
            <div class="col-sm-7">
             <form:select path="bloodGroup" Class="form-control">
             <form:option value="" disabled="true" selected="true" hidden="true">Choose here</form:option>
             <form:option value="apos">A+</form:option>
             <form:option value="aneg">A-</form:option>
             <form:option value="bpos">B+</form:option>
             <form:option value="bneg">B-</form:option>
             <form:option value="opos">O+</form:option>
             <form:option value="oneg">O-</form:option>

             </form:select>
              </div>
             </div>

           
            
            
                 
            <input type="submit" value="Add">
        </form:form>
    </div>


</div>








</body>
</html>





