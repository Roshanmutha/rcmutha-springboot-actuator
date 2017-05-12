package com.rcmutha.SpringInputValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class SpringValidatorController extends WebMvcConfigurerAdapter {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new EmployeeFormValidator());
	}

	@GetMapping("/SpringValidate")
	public String showForm(EmployeeForm employeeForm, Model model) {
		model.addAttribute("employeeForm", new EmployeeForm());
		return "employeeform";
	}

	@PostMapping("/SpringValidate")
	public String checkPersonInfo(EmployeeForm employeeForm, BindingResult bindingResult) {
		// run Spring validator manually
		new EmployeeFormValidator().validate(employeeForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "employeeform";
		}
		return "results";
	}
}