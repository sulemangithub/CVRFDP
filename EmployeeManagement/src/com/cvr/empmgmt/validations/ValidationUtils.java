package com.cvr.empmgmt.validations;

import com.cvr.empmgmt.exeptions.InvalidEmployeeException;

public class ValidationUtils {

	static public boolean validateEmail(String email) throws InvalidEmployeeException
	{
		if(email.contains("@") && email.contains("."))
			return true;

		throw new InvalidEmployeeException("Invalid email");
	}
	
	
}
