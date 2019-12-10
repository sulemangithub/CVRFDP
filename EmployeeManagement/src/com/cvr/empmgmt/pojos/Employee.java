package com.cvr.empmgmt.pojos;

import java.io.Serializable;
import java.time.LocalDate;

import com.cvr.empmgmt.exeptions.InvalidEmployeeException;
import com.cvr.empmgmt.validations.ValidationUtils;

public class Employee implements Comparable<Employee>,Serializable{
	
	private int id;
	private String firstname;
	private String lastname;
	private LocalDate dob;
		
	private Address address;
	private ContactInfo contactInfo;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String firstname, String lastname, LocalDate dob, String email,String contactNo) throws InvalidEmployeeException {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.contactInfo = new ContactInfo(contactNo, email);		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}	
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public class ContactInfo implements Serializable
	{
		private String contactNo;
		private String email;
		
		public ContactInfo() {
			// TODO Auto-generated constructor stub
		}		
		
		public ContactInfo(String contactNo, String email) throws InvalidEmployeeException {
			super();
			
			ValidationUtils.validateEmail(email);			
			
			this.contactNo = contactNo;
			this.email = email;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getContactNo() {
			return contactNo;
		}

		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}		
	}

	public double calculateSalary(){
		return 0.0;
	};
	
	@Override
	public boolean equals(Object obj) {
		
		Employee temp = (Employee) obj;
		return this.id == temp.id;
		
		/*if(temp.id == this.id)
			return true;
		return false;*/		
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", address=" + address + ", contactInfo=" + contactInfo + "]";
	}

	@Override
	public int compareTo(Employee o) {
		//return this.id - o.id; //for ascending order
		return o.id - this.id ;//for descending order
	}
}
