<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
        String user=(String)session.getAttribute("user");
        String target=null;
        String title =null;
        String logout=null;
        boolean login = false;
        //redirect user to home page if already logged in
        if(user!=null){
           target = "addDonor.jsp";
           title = "Add Donor";
           logout ="Log Out";
           login=true;
        }
        else
        {
        	target = "Login.jsp";
            title = "Login";
        }
        
        %>
 
 <ul>
	<li><a href=<%=target %>><%=title %> </a></li> 
 	<li><a href="blood">View Donor </a></li>
 	<li ><a href="Logout.jsp"><c:if test="${user!=null}"><%=logout %></c:if></a></li> 
</ul>
</body>
</html>