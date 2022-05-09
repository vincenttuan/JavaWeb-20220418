<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Random r = new Random();
	int work = r.nextInt(10);
	int eat = r.nextInt(10);
	int commute = r.nextInt(10);
	int watchTV = r.nextInt(10);
	int sleep = r.nextInt(10);
	int coding = r.nextInt(10);
	String chatType = "PieChart"; // PieChart, BarChart, LineChart, ColumnChart
%>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     <%=work %>],
          ['Eat',      <%=eat %>],
          ['Commute',  <%=commute %>],
          ['Watch TV', <%=watchTV %>],
          ['Sleep',    <%=sleep %>],
          ['Coding',   <%=coding %>]
        ]);

        var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.<%=chatType %>(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
