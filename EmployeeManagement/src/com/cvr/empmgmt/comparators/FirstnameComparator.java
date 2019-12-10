package com.cvr.empmgmt.comparators;

import java.util.Comparator;

import com.cvr.empmgmt.pojos.Employee;

public class FirstnameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getFirstname().compareTo(o2.getFirstname());
	}
	
}
