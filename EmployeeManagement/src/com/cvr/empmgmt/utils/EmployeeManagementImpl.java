package com.cvr.empmgmt.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.cvr.empmgmt.comparators.FirstnameComparator;
import com.cvr.empmgmt.comparators.LastnameComparator;
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

	@Override
	public List<Employee> sortEmployeesById() {
		Collections.sort(this.employees);
		return this.employees;
	}

	@Override
	public List<Employee> sortEmployeesByFirstname() {
		Collections.sort(this.employees,new FirstnameComparator());
		return this.employees;
	}

	@Override
	public List<Employee> sortEmployeesByLastName() {
		Collections.sort(this.employees,new LastnameComparator());
		return this.employees;
		
	}

	@Override
	public List<Employee> sortEmployeesByDob() {
		Collections.sort(this.employees,
				(e1,e2)->
					e1.getDob().compareTo(e2.getDob()));
		return this.employees;
	}

	@Override
	public List<Employee> sortEmployeesByEmail() {
		Collections.sort(this.employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
			
				return o2.getContactInfo().getEmail().compareTo(o1.getContactInfo().getEmail());
			}
		});
		return this.employees;
	}
	
	@Override
	public boolean storeData() throws IOException {
		IOUtils.saveEmployees(employees);
		return true;
	}
	
	@Override
	public boolean retriveData() throws ClassNotFoundException, IOException {
		this.employees.addAll(IOUtils.readEmployees());
		return true;
	}
	
	
}
