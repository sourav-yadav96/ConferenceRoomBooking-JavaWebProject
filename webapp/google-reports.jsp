<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Google Chart View Foe Reports</title>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script>
        // Load the chart package
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        // Draw chart with data from server
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                <%= request.getAttribute("chartData") %>
            ]);

            var options = {
                title: 'Room Utilization (%)',
                pieHole: 0.4
            };

            var chart = new google.visualization.PieChart(document.getElementById('roomChart'));
            chart.draw(data, options);
        }
        
       
    </script>
    
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

        form button {
            background-color: #1976d2;
            color: white;
            padding: 10px 16px;
            border: none;
            border-radius: 6px;
            font-weight: bold;
            cursor: pointer;
            margin-bottom: 20px;
        }

        form button:hover {
            background-color: #1565c0;
        }

        #roomChart {
            width: 700px;
            height: 400px;
            margin-top: 20px;
        }
    </style>
    
</head>
<body>
<h2>📊 Room Utilization: Chart View (This Week)</h2>

<form method="get" action="<%=request.getContextPath()%>/googlereports">
   <button type="submit" name="action" value="viewReport">View Chart</button>
</form>
<div id="roomChart" style="width: 700px; height: 400px;"></div>

</body>
</html>