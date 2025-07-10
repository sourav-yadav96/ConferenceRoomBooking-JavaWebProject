<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.demosourav.model.User" %>
<%@ page import="java.util.*" %>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>

<%
    User user = (User) request.getAttribute("user");
    boolean isEdit = user != null;
%>

<html>
<head>
<meta charset="UTF-8">
<title><%= isEdit ? "Edit" : "Add" %> User</title>

<style>
    body {
        background-color: #121212;
        color: #ffffff;
        font-family: Arial, sans-serif;
        padding: 40px;
    }

    h2 {
        color: #90caf9;
        margin-bottom: 25px;
    }

    form {
        background-color: #1e1e1e;
        padding: 25px;
        border-radius: 8px;
        width: 100%;
        max-width: 500px;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"],
    select {
        width: 100%;
        padding: 10px;
        margin: 10px 0 20px;
        background-color: #2c2c2c;
        border: 1px solid #555;
        border-radius: 5px;
        color: #fff;
    }

    input[type="submit"] {
        background-color: #1976d2;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 6px;
        font-weight: bold;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #1565c0;
    }

    label {
        font-weight: bold;
    }
</style>

</head>
<body>

<h2><%= isEdit ? "Edit" : "Add" %> User</h2>
<form action="users" method="post">
    <% if (isEdit) { %>
       <input type="hidden" name="id" value="<%= user.getId() %>"/>
    <% } %>
    UserName <input type="text" name="username" value="<%= isEdit ? user.getUsername() : "" %>" required/><br/>
    Email: <input type="email" name="email" value="<%= isEdit ? user.getEmail() : "" %>" required/><br/>
    Password: <input type="password" name="password" value=""/><br/>
    Role:
    <select name="role">
        <option value="employee" <%= isEdit && "employee".equals(user.getRole()) ? "selected" : "" %>>Employee</option>
        <option value="admin" <%= isEdit && "admin".equals(user.getRole()) ? "selected" : "" %>>Admin</option>
        <option value="facilities_manager" <%= isEdit && "facilities_manager".equals(user.getRole()) ? "selected" : "" %>>Facilities Manager</option>
    </select><br/>
    <input type="submit" value="<%= isEdit ? "Update" : "Add" %> User"/>
</form>

</body>
</html>