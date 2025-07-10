<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

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
<h2> Welcome, In Conference Room Booking System</h2>

<h3>Manage Rooms</h3>
<a href="room-management.jsp">Add/Edit/Delete Rooms</a>

<h3>Manage Users</h3>
<a href="users-management.jsp">Add/Edit/Delete Users</a>

<h3>Approve/Cancel/Reschedule Bookings</h3>
<a href="manage-bookings.jsp">Manage Bookings</a>

</div>

</body>
</html>