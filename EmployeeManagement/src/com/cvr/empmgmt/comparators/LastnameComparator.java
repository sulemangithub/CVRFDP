package com.cvr.empmgmt.comparators;

import java.util.Comparator;

import com.cvr.empmgmt.pojos.Employee;

public class LastnameComparator implements Comparator<Employee> {
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.getLastname().compareTo(o1.getLastname());
	}

}
