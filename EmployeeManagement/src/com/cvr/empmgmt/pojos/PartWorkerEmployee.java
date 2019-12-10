package com.cvr.empmgmt.pojos;

public class PartWorkerEmployee extends Employee{
	
	private int noOfParts;
	private double ratePerPart;
	
	public PartWorkerEmployee() {
		// TODO Auto-generated constructor stub
	}

	public PartWorkerEmployee(int noOfParts, double ratePerPart) {
		super();
		this.noOfParts = noOfParts;
		this.ratePerPart = ratePerPart;
	}

	public int getNoOfParts() {
		return noOfParts;
	}

	public void setNoOfParts(int noOfParts) {
		this.noOfParts = noOfParts;
	}

	public double getRatePerPart() {
		return ratePerPart;
	}

	public void setRatePerPart(double ratePerPart) {
		this.ratePerPart = ratePerPart;
	}
	
	public double calculateSalary()
	{
		return noOfParts*ratePerPart;
	}
	
}
