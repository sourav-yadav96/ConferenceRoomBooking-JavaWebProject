<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.demosourav.model.Booking" %>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Bookings</title>

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
        margin-top: 20px;
        border-radius: 10px;
        overflow: hidden;
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

    .no-bookings {
        background-color: #1e1e1e;
        padding: 20px;
        border-radius: 8px;
        margin-top: 30px;
        box-shadow: 0 2px 8px rgba(255, 255, 255, 0.1);
        color: #ccc;
    }
</style>

</head>
<body>

<h2>My Conference Bookings</h2>
<a href="my-bookings">showBookings</a>

<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
    if (bookings != null && !bookings.isEmpty()) {
%>
    <table border="1">
        <tr>
            <th>RoomId</th>
            <th>BookingDate</th>
            <th>StartTime</th>
            <th>EndTime</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <% for (Booking b : bookings) { %>
            <tr>
                <td><%= b.getRoomId() %></td>
                <td><%= b.getBooking_date() %></td>
                <td><%= b.getStartTime() %></td>
                <td><%= b.getEndTime() %></td>
                <td><%= b.getStatus() %></td>
                <td>
                    <% if (!"Canceled".equals(b.getStatus())) { %>
                        <a href="edit-bookings.jsp?id=<%= b.getId() %>">Edit</a> |
                        <a href="cancel-booking?id=<%= b.getId() %>">Cancel</a>
                    <% } %>
                </td>
            </tr>
        <% } %>
    </table>
<% } else { %>
 <div class="no-bookings">
    <p>No bookings found.</p>
 </div>   
<% } %>

</body>
</html>