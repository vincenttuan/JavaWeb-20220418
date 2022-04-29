package service;

import java.util.concurrent.CopyOnWriteArrayList;

import entity.Employee;

// 支援 SingleTon Pattern
public class EmployeeService {
	private CopyOnWriteArrayList<Employee> employees = new CopyOnWriteArrayList<Employee>();
	
	private static final EmployeeService _instance = new EmployeeService();
	
	private EmployeeService() {
		
	}
	
	public static EmployeeService getInstance() {
		return _instance;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
		System.out.println(findAll());
	}
	
	public CopyOnWriteArrayList<Employee> findAll() {
		return employees;
	}
	
}
