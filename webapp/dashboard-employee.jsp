<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Dashboard</title>

<style>
    * {
        box-sizing: border-box;
    }

    body {
        background-color: #121212;
        color: #ffffff;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
 <%--       align-items: center;  --%>
        justify-content: flex-start;
        min-height: 100vh;
        padding-top: 20px;
    }

    h2 {
        color: #90caf9;
        margin-bottom: 10px;
    }

    h3 {
        margin-top: 30px;
        margin-bottom: 10px;
        color: #ffffff;
    }

    a {
        color: #f2bb30;
        text-decoration: none;
        font-weight: bold;
        font-size: 16px;
    }

    a:hover {
        text-decoration: underline;
    }

    .success {
        background-color: #2e7d32;
        color: #209915;
        padding: 10px 20px;
        border-radius: 5px;
        margin-top: 15px;
    }

    .content-container {
        max-width: 1000px;
        width: 100%;
        padding: 20px;
        background-color: #1e1e1e;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.4);
    }
</style>

</head>
<body>
<div class="content-container">

<h2>Welcome, In Conference Room Booking System</h2>

<%--  <% if (request.getAttribute("success") != null)%>
  <p style="color:green;"><%=request.getAttribute("success")%></p>  --%>
  
<% 
    if (request.getAttribute("success") != null) {
%>
         <p><%=request.getAttribute("success")%></p>
<% 

    } 
%>
<br>
<h3>-> Quick Search & Book Room</h3>
<a href="rooms.jsp">Search&Book</a>

<h3>-> My Bookings..</h3>
<a href="my-bookings.jsp">Show my Bookings</a>

</div>

</body>
</html>