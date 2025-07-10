<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.demosourav.model.Booking" %>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Booking</title>

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
    }

    input[type="date"],
    input[type="time"],
    input[type="text"],
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: none;
        border-radius: 5px;
        background-color: #2c2c2c;
        color: #ffffff;
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
</style>

</head>
<body>

<h2>Edit Booking</h2>
<%
    String id = request.getParameter("id");
%>
<form action="edit-booking" method="get">
    <input type="hidden" name="id" value="<%= id %>" />
    New Date: <input type="date" name="date" required /><br/><br>
    Start Time: <input type="time" name="startTime" required /><br/><br>
    End Time: <input type="time" name="endTime" required /><br/><br>
    Purpose: <input type="text" name="purpose" /><br/><br>
    <input type="submit" value="Update Booking" />
</form>

</body>
</html>