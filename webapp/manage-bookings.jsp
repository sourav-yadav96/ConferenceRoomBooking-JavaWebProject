<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.demosourav.model.Booking, java.util.List" %>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Bookings</title>
  
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
        background-color: #1e1e1e;
        margin-top: 20px;
    }

    th, td {
        padding: 12px;
        border: 1px solid #444;
        text-align: center;
    }

    th {
        background-color: #2c2c2c;
        color: #ffffff;
    }

    td {
        background-color: #1a1a1a;
    }

    form.inline {
        display: inline-block;
        margin: 4px 0;
    }

    input[type="text"] {
        width: 160px;
        padding: 5px;
        background-color: #2c2c2c;
        color: white;
        border: 1px solid #555;
        border-radius: 4px;
    }

    button {
        background-color: #1976d2;
        color: white;
        padding: 6px 12px;
        border: none;
        border-radius: 4px;
        font-weight: bold;
        cursor: pointer;
        margin-top: 4px;
    }

    button:hover {
        background-color: #1565c0;
    }

    .no-conflicts {
        font-size: 18px;
        color: #ccc;
    }
</style>
</head>
<body>

<h2>Manage Bookings: Approve/Cancel/Reschedule</h2>
 <form method="get" action="<%=request.getContextPath()%>/conflicts">
   <button type="submit" name="action" value="viewBookings">View Pending Bookings</button>
</form>

  <%
    List<Booking> conflicts = (List<Booking>) request.getAttribute("conflicts");
    if (conflicts == null || conflicts.isEmpty()) {
  %>
      <p>No Pending Bookings found.</p>
  <%
    } else {
  %>
      <table>
        <tr>
          <th>Booking ID</th>
          <th>Room ID</th>
          <th>Booking Date</th>
          <th>Start Time</th>
          <th>End Time</th>
          <th>Status</th>
          <th>Action</th>
        </tr>
        <%
          for (Booking b : conflicts) {
        %>
          <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getRoomId() %></td>
            <td><%= b.getBooking_date() %>
            <td><%= b.getStartTime() %></td>
            <td><%= b.getEndTime() %></td>
            <td><%= b.getStatus() %></td>
            <td>
              <form class="inline" method="post" action="<%= request.getContextPath() %>/conflicts">
                <input type="hidden" name="bookingId" value="<%= b.getId() %>" />
                <button type="submit" name="action" value="approve">Approve</button>
              </form> <br>
              <form class="inline" method="post" action="<%= request.getContextPath() %>/conflicts">
                <input type="hidden" name="bookingId" value="<%= b.getId() %>" />
                <button type="submit" name="action" value="reschedule">Reschedule</button>
                <input type="text" name="newTime" placeholder="NewStart-Time HH:MM" />
              </form><br>
              <form class="inline" method="post" action="<%= request.getContextPath() %>/conflicts">
                <input type="hidden" name="bookingId" value="<%= b.getId() %>" />
                <button type="submit" name="action" value="cancel">Cancel</button>
              </form>
            </td>
          </tr>
        <%
          }
        %>
      </table>
  <%
    }
  %>

</body>
</html>