package com.cvr.empmgmt.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cvr.empmgmt.exeptions.InvalidEmployeeException;
import com.cvr.empmgmt.pojos.Address;
import com.cvr.empmgmt.pojos.Employee;
import com.cvr.empmgmt.pojos.Employee.ContactInfo;
import com.cvr.empmgmt.pojos.PartWorkerEmployee;

public class EmployeeManagementImpl implements EmployeeManagement {

	List<Employee> employees = new ArrayList<>();
	
	public EmployeeManagementImpl() throws InvalidEmployeeException {
		this.init();
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

	/** 
	 * @see com.cvr.empmgmt.utils.EmployeeManagement#getEmployee(int)
	 */
	@Override
	public Employee getEmployee(int id) {
		Employee temp = new Employee();
		temp.setId(id);
		int index = this.employees.indexOf(temp); //This method will internally invokes an equals method onto the object we are passing it it.		
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

	public void init() throws InvalidEmployeeException
	{
		
		Employee emp1 = new PartWorkerEmployee(50, 1000);
		emp1.setId(98459);
		emp1.setFirstname("Ramesh");
		emp1.setLastname(" Bist");
		emp1.setDob(LocalDate.parse("1990-09-09"));
		
		Address address = new Address("MG road", "Pune", "MH","INDIA", 411023);
		ContactInfo cinfo = emp1.new ContactInfo("909090","ramesh@gmail.com");
		emp1.setAddress(address);
		emp1.setContactInfo(cinfo);
		
		this.employees.add(emp1);
		
		Employee emp2 = new PartWorkerEmployee(50, 1000);
		emp2.setId(57685);
		emp2.setFirstname("Ganesh");
		emp2.setLastname("Gupta");
		emp2.setDob(LocalDate.parse("1985-02-23"));
		
		Address address2 = new Address("MG road", "Pune", "MH","INDIA", 411023);
		ContactInfo cinfo2 = emp1.new ContactInfo("909090","ganesh@gmail.com");
		emp2.setAddress(address2);
		emp2.setContactInfo(cinfo2);
		this.employees.add(emp2);		
	}
	
	
}
