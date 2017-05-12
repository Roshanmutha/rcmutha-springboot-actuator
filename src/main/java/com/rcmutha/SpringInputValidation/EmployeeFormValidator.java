package com.rcmutha.SpringInputValidation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class EmployeeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return EmployeeForm.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		EmployeeForm employeeForm = (EmployeeForm) arg0;
		if (employeeForm.getName().length() < 2 || employeeForm.getName().length() > 30) {
			// ValidationUtils.reject(errors, "name", "Name length > 2 and <
			// 30");
			errors.rejectValue("name", "name.length");
		}
	}

}
