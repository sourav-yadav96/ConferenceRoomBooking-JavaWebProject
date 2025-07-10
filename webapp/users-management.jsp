<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.demosourav.model.User" %>
<%@ page import="java.util.*" %>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>

<style>
    body {
        background-color: #121212;
        color: #ffffff;
        font-family: Arial, sans-serif;
        padding: 20px;
    }

    h2 {
        color: #90caf9;
        margin-bottom: 20px;
    }

    a {
        color: #f2bb30;
        text-decoration: none;
        margin-right: 10px;
    }

    a:hover {
        text-decoration: underline;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #1e1e1e;
        border-radius: 10px;
        overflow: hidden;
        margin-top: 20px;
    }

    th, td {
        padding: 12px 16px;
        border-bottom: 1px solid #333;
        text-align: left;
    }

    th {
        background-color: #2c2c2c;
        color: #ffcc80;
    }

    tr:hover {
        background-color: #2a2a2a;
    }

    .add-btn {
        background-color: #1976d2;
        color: white;
        padding: 10px 16px;
        border-radius: 5px;
        display: inline-block;
        font-weight: bold;
    }

    .add-btn:hover {
        background-color: #1565c0;
    }
</style>

</head>
<body>

<h2> Manage Users in Conference Room Booking System</h2>
<a href="users-form.jsp">Add User</a><br/><br/>

<%
    List<User> users = (List<User>) request.getAttribute("users");
    if (users != null) {
%>
<table border="1">
    <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>
    <% for (User u : users) { %>
    <tr>
        <td><%= u.getUsername() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getRole() %></td>
        <td>
            <a href="users?id=<%= u.getId() %>">Edit</a> |
            <a href="users?action=delete&id=<%= u.getId() %>">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
<% } %>
</body>
</html>