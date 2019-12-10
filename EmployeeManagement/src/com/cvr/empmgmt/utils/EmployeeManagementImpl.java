package com.cvr.empmgmt.utils;

import java.util.ArrayList;
import java.util.List;

import com.cvr.empmgmt.pojos.Employee;

public class EmployeeManagementImpl implements EmployeeManagement {

	List<Employee> employees = new ArrayList<>();
	
	private int data;
	
	public EmployeeManagementImpl() {
		this.data = 20;
	}
	
	@Override
	public boolean addEmployee(Employee employee) {
		this.employees.add(employee);			
		return true;
	}

	@Override
	public boolean removeEmployee(int id) {
		
		Employee temp = new Employee();
		temp.setId(id);
		int index = this.employees.indexOf(temp);
		
		if(index != -1)
		{
			this.employees.remove(index);
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.cvr.empmgmt.utils.EmployeeManagement#getEmployee(int)
	 */
	@Override
	public Employee getEmployee(int id) {
		Employee temp = new Employee();
		temp.setId(id);
		int index = this.employees.indexOf(temp);		
		return this.employees.get(index); 
		}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return this.employees;
	}
	
	@Override
	public double getSalary(int id) {
		
		Employee temp = this.getEmployee(id);
		return temp.calculateSalary();
	}

}
