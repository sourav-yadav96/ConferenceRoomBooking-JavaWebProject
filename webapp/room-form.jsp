<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.demosourav.model.Room" %>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>

<%
    Room room = (Room) request.getAttribute("room");
    boolean isEdit = (room != null);
%>
<html>
<head>
<meta charset="UTF-8">
<title><%= isEdit ? "Edit" : "Add" %> Room</title>

<style>
    body {
        background-color: #121212;
        color: #ffffff;
        font-family: Arial, sans-serif;
        padding: 40px;
    }

    h2 {
        color: #90caf9;
        margin-bottom: 30px;
    }

    form {
        max-width: 500px;
        background-color: #1e1e1e;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 0 15px rgba(0,0,0,0.5);
    }

    input[type="text"],
    input[type="number"],
    input[type="date"],
    input[type="time"],
    textarea {
        width: 100%;
        padding: 10px;
        margin-top: 6px;
        margin-bottom: 20px;
        background-color: #2a2a2a;
        color: white;
        border: 1px solid #555;
        border-radius: 4px;
    }

    input[type="checkbox"] {
        margin-right: 10px;
    }

    input[type="submit"] {
        background-color: #1976d2;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
        width: 100%;
    }

    input[type="submit"]:hover {
        background-color: #1565c0;
    }

    label {
        display: block;
        margin-bottom: 10px;
        color: #ffcc80;
    }
</style>

</head>
<body>

<h2><%= isEdit ? "Edit" : "Add" %> Room</h2>
<form action="room" method="post">
    <% if (isEdit) { %>
     <input type="hidden" name="id" value="<%= isEdit ? room.getId() : "" %>"/><br>
    <% } %>
   
    Room Name <input type="text" name="name" value="<%= isEdit ? room.getName() : "" %>" required/><br/><br>
    Capacity: <input type="number" name="capacity" value="<%= isEdit ? room.getCapacity() : "" %>" required/><br/><br>
    Projector: <input type="checkbox" name="projector" <%= isEdit && room.isProjector() ? "checked" : "" %>/><br/><br>
    Whiteboard: <input type="checkbox" name="whiteboard" <%= isEdit && room.isWhiteboard() ? "checked" : "" %>/><br/><br>
    <input type="submit" value="<%= isEdit ? "Update" : "Add" %> Room"/>
</form>

</body>
</html>