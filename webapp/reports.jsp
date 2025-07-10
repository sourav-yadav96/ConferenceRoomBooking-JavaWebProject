<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.demosourav.model.RoomUsageReport" %>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Utilization Report</title>

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

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        padding: 12px;
        border: 1px solid #444;
        text-align: center;
    }

    th {
        background-color: #1e1e1e;
        color: #fc03d3;
    }

    td {
        background-color: #2a2a2a;
    }

    form button {
        background-color: #1976d2;
        color: white;
        padding: 10px 16px;
        border: none;
        border-radius: 6px;
        font-weight: bold;
        cursor: pointer;
        margin-top: 10px;
    }

    form button:hover {
        background-color: #1565c0;
    }
</style>

</head>
<body>

<h2>Room Utilization Reports: Tabular View</h2>

<form method="get" action="<%=request.getContextPath()%>/reports">
   <button type="submit" name="action" value="viewReport">View Reports</button>
</form>

<table border="1">
    <tr>
        <th>Room Name</th>
        <th>Total Bookings</th>
        <th>Total Hours</th>
        <th>Utilization %</th>
    </tr>
    <%
        List<RoomUsageReport> reports = (List<RoomUsageReport>) request.getAttribute("reports");
        if (reports != null) {
            for (RoomUsageReport r : reports) {
    %>
    <tr>
        <td><%= r.getRoomName() %></td>
        <td><%= r.getTotalBookings() %></td>
        <td><%= r.getTotalHours() %></td>
        <td><%= String.format("%.2f", r.getUtilizationPercentage()) %>%</td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="4">No data available.</td>
    </tr>
    <%
        }
    %>
</table>


</body>
</html>