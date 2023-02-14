package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.CalcForm;
import com.example.validator.CalcValidator;

@Controller
public class ValidationController {
	
	@ModelAttribute
	public CalcForm setUpForm() {
		return new CalcForm();
	}
	
	@GetMapping("show")
	public String showView() {
		return "entry";
	}
	
	@PostMapping("calc")
	public String confirmView(@Validated CalcForm form, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "entry";
		}
		Integer result = form.getLeftNum() + form.getRightNum();
		model.addAttribute("result", result);
		return "confirm";
	}
	
	@Autowired
	CalcValidator calcValidator;
	@InitBinder("calcForm")
	public void intBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(calcValidator);
	}

}
