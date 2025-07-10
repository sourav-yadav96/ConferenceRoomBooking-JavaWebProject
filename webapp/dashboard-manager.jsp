<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Dashboard</title>

<style>
    body {
        background-color: #121212;
        color: #ffffff;
        font-family: Arial, sans-serif;
        padding: 30px;
    }

    h2 {
        color: #90caf9;
        margin-bottom: 20px;
    }

    h3 {
        color: #ffffff;
        margin-top: 30px;
    }

    a {
        display: inline-block;
        color: #f2bb30;
        background-color: #1976d2;
        padding: 10px 16px;
        border-radius: 6px;
        text-decoration: none;
        font-weight: bold;
        margin-top: 10px;
    }

    a:hover {
        background-color: #1565c0;
    }
</style>

</head>
<body>
<h2>Welcome, In Conference Room Booking Application</h2>

<h3>Utilization Reports: Tabular View</h3>
<a href="reports.jsp">View Analytics</a>

<%-- 
<h3>Utilization Reports: Google Chart View</h3>
<a href="google-reports.jsp">View Chart</a>
--%>

</body>
</html>