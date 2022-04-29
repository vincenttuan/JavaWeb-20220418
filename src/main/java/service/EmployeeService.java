package service;

import java.util.concurrent.CopyOnWriteArrayList;

import entity.Employee;

// 支援 SingleTon Pattern
public class EmployeeService {
	private CopyOnWriteArrayList<Employee> employees = new CopyOnWriteArrayList<Employee>();
	
	public static final EmployeeService _instance = new EmployeeService();
	
	private EmployeeService() {
		
	}
	
	public EmployeeService getInstance() {
		return _instance;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public CopyOnWriteArrayList<Employee> findAll() {
		return employees;
	}
	
}
