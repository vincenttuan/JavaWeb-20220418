<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	class Employee {
		String name;
		int salary;
		boolean fullTime;
		Employee(String name, int salary, boolean fullTime) {
			this.name = name;this.salary = salary;this.fullTime = fullTime;
		}
	}
	
	List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList();
		employees.add(new Employee("Mary", 42000, true));
		employees.add(new Employee("John", 35000, false));
		employees.add(new Employee("Bob", 72000, true));
		employees.add(new Employee("Alice", 28000, false));
		employees.add(new Employee("Jim", 55000, true));
		return employees;
	}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工薪資表</title>
</head>
<body>

</body>
</html>