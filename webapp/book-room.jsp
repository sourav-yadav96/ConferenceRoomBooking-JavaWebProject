<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Room</title>

<style>
    body {
        background-color: #121212;
        color: #ffffff;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
    }

    h2 {
        color: #90caf9;
        margin-bottom: 20px;
    }

    form {
        background-color: #1e1e1e;
        padding: 25px;
        border-radius: 10px;
        max-width: 500px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.4);
        margin-top: 20px;
    }

    input[type="date"],
    input[type="time"],
    input[type="text"],
    textarea,
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: none;
        border-radius: 5px;
        background-color: #2c2c2c;
        color: #ffffff;
    }

    textarea {
        resize: vertical;
        min-height: 80px;
    }

    input[type="submit"] {
        background-color: #1976d2;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #1565c0;
    }

    .error-box {
        background-color: #2c1e1e;
        color: #ff6e6e;
        padding: 15px;
        border-radius: 8px;
        margin-bottom: 20px;
        box-shadow: 0 2px 8px rgba(255, 0, 0, 0.2);
        max-width: 600px;
    }

    .error-box ul {
        margin-top: 10px;
        padding-left: 20px;
    }

    .error-box li {
        color: #ffcdd2;
    }
</style>

</head>
<body>

<h2>Book a Conference Room</h2>

<% if (request.getAttribute("error") != null) { %>
<%--   <p style="color:red;">  <%=request.getAttribute("error")%></p>  --%>

<div class="error-box">
<p> <%=request.getAttribute("error")%></p>
  <p>Suggested Available Slots:</p>
  <ul>
  
  <% for (String[] slot : (List<String[]>)request.getAttribute("alternatives")) { %>
    <li><%=slot[0] %> to <%=slot[1] %></li>
  <% } %>
  </ul>
  </div>
<% } %>


<form action="bookRoom" method="get">
    <input type="hidden" name="roomId" value="<%= request.getParameter("roomId") %>" />
    Date: <input type="date" name="date" required /><br/><br>
    Start Time: <input type="time" name="startTime" required /><br/><br>
    End Time: <input type="time" name="endTime" required /><br/><br>
    Purpose: <input type="text" name="purpose" required /><br/><br>
    Special Requests: <textarea name="requests"></textarea><br/><br>
    <input type="submit" value="Confirm Booking" />
</form>

</body>
</html>