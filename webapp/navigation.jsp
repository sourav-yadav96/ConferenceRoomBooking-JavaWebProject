
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Navigation</title>
<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #121212;
        color: #ffffff;
    }

    .navbar {
        background-color: #1e1e1e;
        padding: 15px 30px;
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        border-bottom: 1px solid #333;
    }

    .navbar h3 {
        margin: 0 0 10px 0;
        color: #90caf9;
    }

    nav ul {
        list-style: none;
        padding: 0;
        margin: 0;
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
    }

    nav ul li {
        /* Let flex handle spacing */
    }

    nav ul li a {
        text-decoration: none;
        color: #f2bb30;
        padding: 8px 14px;
        border-radius: 5px;
        transition: background-color 0.3s ease;
        display: inline-block;
        background-color: #2c2c2c;
    }

    nav ul li a:hover {
        background-color: #1976d2;
    }

    hr {
        border: none;
        border-top: 1px solid #333;
        margin: 0;
    }
</style>
</head>
<body>

<%
    String role = (String) session.getAttribute("role");
    if (role == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<div class="navbar">
    <h3>Welcome, <%= role.toUpperCase() %></h3>
    <nav>
        <ul>
            <% if ("employee".equalsIgnoreCase(role)) { %>
                <li><a href="dashboard-employee.jsp">Employee Dashboard</a></li>
                <li><a href="rooms.jsp">Search & Book Room</a></li>
                <li><a href="my-bookings.jsp">My Bookings</a></li>
            <% } else if ("admin".equalsIgnoreCase(role)) { %>
                <li><a href="dashboard-admin.jsp">Admin Dashboard</a></li>
                <li><a href="room-management.jsp">Manage Rooms</a></li>
                <li><a href="users-management.jsp">Manage Users</a></li>
                <li><a href="manage-bookings.jsp">Manage Bookings</a></li>
            <% } else if ("facility_manager".equalsIgnoreCase(role)) { %>
                <li><a href="dashboard-manager.jsp">Manager Dashboard</a></li>
                <li><a href="reports.jsp">Reports & Analytics</a></li>
      <%--          <li><a href="google-reports.jsp">Report Charts</a></li>    --%> 
            <% } %>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
    </nav>
</div>
<hr/>

</body>
</html>