<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.demosourav.model.Room" %>
<%@ include file="navigation.jsp" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Rooms</title>

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
        margin-bottom: 15px;
    }

    form {
        background-color: #1e1e1e;
        padding: 20px;
        border-radius: 10px;
        max-width: 500px;
        margin-bottom: 30px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.4);
    }

    input[type="date"],
    input[type="time"],
    input[type="number"],
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: none;
        border-radius: 5px;
        background-color: #2c2c2c;
        color: #ffffff;
    }

    input[type="checkbox"] {
        margin-right: 8px;
    }

    input[type="submit"] {
        background-color: #1976d2;
        cursor: pointer;
        font-weight: bold;
    }

    input[type="submit"]:hover {
        background-color: #1565c0;
    }

    .room-card {
        background-color: #1e1e1e;
        padding: 20px;
        border-radius: 10px;
        margin-bottom: 20px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.3);
        max-width: 600px;
    }

    .room-card b {
        color: #ffcc80;
    }

    hr {
        border: none;
        border-top: 1px solid #444;
        margin: 20px 0;
    }

    .room-card form {
        margin-top: 10px;
    }
</style>

</head>
<body>
<h2>Search Rooms</h2>
<form action="rooms" method="get">
    Date: <input type="date" name="date" required /> <br><br>
    Time: <input type="time" name="time" required /> <br><br>
    Capacity: <input type="number" name="capacity" />  <br><br>
    Equipment:
    <input type="checkbox" name="equipment" value="Projector" />Projector 
    <input type="checkbox" name="equipment" value="Whiteboard" />Whiteboard <br><br>
    <input type="submit" value="Search" /> <br><br>
</form>

    <h2>Available Rooms For Bookings.. </h2>
<%
    List<Room> roomList = (List<Room>) request.getAttribute("roomList");
    if (roomList != null) {
        for (Room room : roomList) {
%>
          <div class="room-card">  
            <hr/>
            <b>Name:</b> <%= room.getName() %><br/>
            <b>Capacity:</b> <%= room.getCapacity() %><br/>
            <b>Features:</b> <%= room.getFeatures() %><br/>
            <form action="book-room.jsp" method="get">
                <input type="hidden" name="roomId" value="<%= room.getId() %>" />
                <input type="submit" value="Book Now" />
            </form>
            </div>
<%
        }
    }
%>


</body>
</html>