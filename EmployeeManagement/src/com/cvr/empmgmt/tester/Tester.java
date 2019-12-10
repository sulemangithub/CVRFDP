package com.cvr.empmgmt.tester;

import java.time.LocalDate;
import java.util.Scanner;

import com.cvr.empmgmt.exeptions.InvalidEmployeeException;
import com.cvr.empmgmt.pojos.Address;
import com.cvr.empmgmt.pojos.Employee;
import com.cvr.empmgmt.pojos.PartWorkerEmployee;
import com.cvr.empmgmt.pojos.SalariedEmployee;
import com.cvr.empmgmt.pojos.Employee.ContactInfo;
import com.cvr.empmgmt.utils.EmployeeManagement;
import com.cvr.empmgmt.utils.EmployeeManagementImpl;

public class Tester {
	
	public static void main(String[] args) {
		
		EmployeeManagement empmgmt = new EmployeeManagementImpl();
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
		System.out.println("Enter your choice:");
		System.out.println("1. add partworker employee");
		System.out.println("2. add salaried employee");
		System.out.println("3. remove employee");
		System.out.println("4. view employee");
		System.out.println("5. view employees");
		System.out.println("0. exit");
		
		int choice = scan.nextInt();
		
		switch(choice)
		{
			case 1:
				
				System.out.println("Enter id, firstname, lastname, dob, contact, email, street, city, state, country, pincode");
				
				int id = scan.nextInt();
				String firstname = scan.next();
				String lastname = scan.next();
				LocalDate dob = LocalDate.parse(scan.next());
				String contactNo = scan.next();
				String email = scan.next();
				String street = scan.next();
				String city = scan.next();
				String state = scan.next();
				String country = scan.next();
				long pincode = scan.nextLong();
				
				int noOfParts = scan.nextInt();
				double ratePerPart = scan.nextDouble();
				
				Employee temp = new PartWorkerEmployee(noOfParts, ratePerPart);
				temp.setId(id);
				temp.setFirstname(firstname);
				temp.setLastname(lastname);
				temp.setDob(dob);
				
				try
				{
				ContactInfo cinfo = temp.new ContactInfo(contactNo,email);
				temp.setContactInfo(cinfo);
				
				Address address = new Address(street, city, state, country, pincode);
				temp.setAddress(address);				
				
				if(empmgmt.addEmployee(temp))
				{
					System.out.println("Employee added successfully");
				}
				else
				{
					System.out.println("Could not add employee");
				}
				}
				catch(InvalidEmployeeException e)
				{
					e.printStackTrace();
				}
				
				break;
			case 2:
				
				System.out.println("Enter id, firstname, lastname, dob, contact, email, street, city, state, country, pincode");
				
				id = scan.nextInt();
				firstname = scan.next();
				lastname = scan.next();
				dob = LocalDate.parse(scan.next());
				contactNo = scan.next();
				email = scan.next();
				street = scan.next();
				city = scan.next();
				state = scan.next();
				country = scan.next();
				pincode = scan.nextLong();
				
				double hra = scan.nextDouble();
				double ta = scan.nextDouble();
				double basic = scan.nextDouble();
				
				temp = new SalariedEmployee(hra, basic, ta);
				
				try
				{
				ContactInfo cinfo1 = temp.new ContactInfo(contactNo,email);
				temp.setContactInfo(cinfo1);
				
				temp.setId(id);
				temp.setFirstname(firstname);
				temp.setLastname(lastname);
				temp.setDob(dob);
				Address address = new Address(street, city, state, country, pincode);
				temp.setAddress(address);
				
				if(empmgmt.addEmployee(temp))
				{
					System.out.println("Employee added successfully");					
				}
				else
				{
					System.out.println("Could not add employee");
				}				
				}catch(InvalidEmployeeException e)
				{
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter id");
				id = scan.nextInt();
				
				if(empmgmt.removeEmployee(id))
				{
					System.out.println("Employee deleted successfully");
				}
				else
				{
					System.out.println("Could not delete employee");
				}
				
				break;
			case 4:
				
				System.out.println("Enter id");
				id = scan.nextInt();
				
				temp = empmgmt.getEmployee(id);
				
				if(temp != null)
				{
					System.out.println(temp);
				}
				else
				{
					System.out.println("Employee not found!");
				}
				
				break;
			case 5:
				for(Employee e : empmgmt.getEmployees())
				{
					System.out.println(e);
				}
				break;
			case 0:
				System.out.println("THANK YOU");
				System.exit(0);		
		}
	}
}
}
