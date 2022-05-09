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
	int w = 450;
	int h = 250;
%>
<html>
  <head>
  	<meta http-equiv="refresh" content="1"> <!-- 每一秒鐘自動更新網頁一次 -->
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
          title: 'My Daily Activities',
          is3D: true
        };

        var piechart = new google.visualization.PieChart(document.getElementById('piechart'));
        
        piechart.draw(data, options);
        
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: <%=w %>px; height: <%=h %>px;"></div>
    
  </body>
</html>
