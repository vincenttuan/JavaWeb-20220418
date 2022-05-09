<%@page import="entity.Employee"%>
<%@page import="java.util.ArrayList, java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	static List<Employee> employees = new ArrayList();
	class Employee {
		String name;
		int salary;
		boolean fullTime;
		Employee(String name, int salary, boolean fullTime) {
			this.name = name;this.salary = salary;this.fullTime = fullTime;
		}
	}
	
	public void jspInit() {
		employees.add(new Employee("Mary", 42000, true));
		employees.add(new Employee("John", 35000, false));
		employees.add(new Employee("Bob", 72000, true));
		employees.add(new Employee("Alice", 28000, false));
		employees.add(new Employee("Jim", 55000, true));
	}
	
	List<Employee> getEmployees() {
		return employees;
	}

%>
<%
	// 取得表單傳來的資料
	String flag = request.getParameter("flag");
	// 判斷 flag 是否有資料
	if(flag != null) {
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String fullTime = request.getParameter("fullTime");
		// 建立 Employee 物件
		Employee emp = new Employee(name, Integer.parseInt(salary), (fullTime==null?false:true));
		// 將表單資料加入到集合
		employees.add(emp);
	}
%>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
	<title>員工薪資表</title>
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['table', 'corechart']});
      google.charts.setOnLoadCallback(drawTable);

      function drawTable() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Name');
        data.addColumn('number', 'Salary');
        data.addColumn('boolean', 'Full Time Employee');
        data.addRows([
        	<% for(Employee emp : getEmployees()) { %>	
          		['<%=emp.name %>', <%=emp.salary %>, <%=emp.fullTime %>],
          	<% } %>
        ]);

        var table = new google.visualization.Table(document.getElementById('table_div'));

        table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
      }
    </script>
  </head>
  <body style="padding: 15px">
  	<form class="pure-form" method="post">
  		<legend>Employee Form</legend>
  		<input type="text" placeholder="請輸入名稱" name="name" /><p />
  		<input type="number" placeholder="請輸入薪資" name="salary" /><p />
  		<input type="checkbox" value="true" name="fullTime" /> Full-Time<p />
  		<input type="hidden" value="true" name="flag" />
  		<button type="submit" class="pure-button pure-button-primary">Add</button>
  	</form>
    <div id="table_div"></div>
  </body>
</html>
