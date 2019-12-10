package com.cvr.empmgmt.pojos;

public class SalariedEmployee extends Employee{
	
	private double hra;
	private double basic;
	private double ta;
	
	public SalariedEmployee() {
		// TODO Auto-generated constructor stub
	}

	public SalariedEmployee(double hra, double basic, double ta) {
		super();
		this.hra = hra;
		this.basic = basic;
		this.ta = ta;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getTa() {
		return ta;
	}

	public void setTa(double ta) {
		this.ta = ta;
	}
	
	public double calculateSalary()
	{
		return basic+hra+ta;
	}
	
	
}
