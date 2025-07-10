<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.demosourav.model.Room" %>
<%@ page import="java.util.*" %>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Rooms</title>

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

    a {
        color: #f2bb30;
        text-decoration: none;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #1e1e1e;
        box-shadow: 0 4px 12px rgba(0,0,0,0.4);
        border-radius: 8px;
        overflow: hidden;
        margin-top: 20px;
    }

    th, td {
        padding: 12px 15px;
        border: 1px solid #333;
        text-align: center;
    }

    th {
        background-color: #2c2c2c;
        color: #ffcc80;
    }

    td {
        background-color: #2a2a2a;
    }

    .action-links a {
        margin: 0 8px;
        color: #81d4fa;
    }

    .action-links a:hover {
        color: #29b6f6;
    }

    .add-link {
        display: inline-block;
        margin-bottom: 15px;
        background-color: #1976d2;
        color: white;
        padding: 10px 15px;
        border-radius: 6px;
        text-decoration: none;
        transition: background-color 0.3s;
    }

    .add-link:hover {
        background-color: #1565c0;
    }
</style>

</head>
<body>

<h2> Manage Conference Rooms</h2>
<a href="room-form.jsp">Add Room</a>
<br/><br/>

<%
    List<Room> rooms = (List<Room>) request.getAttribute("rooms");
    if (rooms != null) {
%>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Capacity</th>
        <th>Projector</th>
        <th>Whiteboard</th>
        <th>Actions</th>
    </tr>
    <% for (Room r : rooms) { %>
        <tr>
            <td><%= r.getName() %></td>
            <td><%= r.getCapacity() %></td>
            <td><%= r.isProjector() ? "Yes" : "No" %></td>
            <td><%= r.isWhiteboard() ? "Yes" : "No" %></td>
            <td>
                <a href="room?id=<%= r.getId() %>">Edit</a> |
                <a href="room?action=delete&id=<%= r.getId() %>">Delete</a>
            </td>
        </tr>
    <% } %>
</table>
<% } %>

</body>
</html>