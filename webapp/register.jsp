<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #121212;
        color: #f0f0f0;
        margin: 0;
        padding: 0;
    }

    h2 {
        text-align: center;
        margin-top: 30px;
        color: #c034c9;
    }

    form {
        width: 400px;
        margin: 30px auto;
        background-color: #1e1e1e;
        padding: 25px 30px;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.4);
    }

    input[type="text"],
    input[type="email"],
    input[type="password"],
    select {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        margin-bottom: 20px;
        background-color: #2c2c2c;
        color: #ffffff;
        border: 1px solid #444;
        border-radius: 5px;
        box-sizing: border-box;
        font-size: 14px;
    }

    input[type="submit"] {
        width: 100%;
        background-color: #007BFF;
        color: white;
        padding: 10px;
        font-size: 16px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    p {
        text-align: center;
        font-weight: bold;
        margin-top: 20px;
    }
</style>

</head>
<body>

<h2>Register New User</h2>

<form action="register" method="post">
    Username: <input type="text" name="username" required /><br/><br/>
    Email: <input type="email" name="email" required /><br/><br/>
    Password: <input type="password" name="password" required /><br/><br/>
    Role:
    <select name="role">
        <option value="EMPLOYEE">Employee</option>
        <option value="ADMIN">Admin</option>
        <option value="FACILITY_MANAGER">Facility Manager</option>
    </select><br/><br/>

    <input type="submit" value="Register" />
</form>

<% String msg = (String) request.getAttribute("message");
   if (msg != null) { %>
    <p style="color:green;"><%= msg %></p>
<% } %>

</body>
</html>