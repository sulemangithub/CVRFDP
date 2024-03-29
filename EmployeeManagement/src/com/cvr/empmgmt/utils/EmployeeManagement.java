package com.cvr.empmgmt.utils;

import java.util.List;

import com.cvr.empmgmt.pojos.Employee;

public interface EmployeeManagement {

	public boolean addEmployee(Employee employee);
	public boolean removeEmployee(int id);
	public Employee getEmployee(int id);
	public List<Employee> getEmployees();
	public double getSalary(int id);
	public List<Employee> sortEmployeesById();
	public List<Employee> sortEmployeesByFirstname();
	public List<Employee> sortEmployeesByLastName();
	public List<Employee> sortEmployeesByDob();
	public List<Employee> sortEmployeesByEmail();
	public boolean storeData() throws Exception;
	public boolean retriveData() throws Exception;
	
	
}
