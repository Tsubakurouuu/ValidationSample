package com.example.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.form.CalcForm;

@Component
public class CalcValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO 自動生成されたメソッド・スタブ
		return CalcForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO 自動生成されたメソッド・スタブ
		CalcForm form = (CalcForm)target;
		if(form.getLeftNum() != null && form.getRightNum() != null) {
			if (!((form.getLeftNum() % 2 == 1) && (form.getRightNum() % 2 == 0))) {
				errors.reject("com.example.demo.validator.CalcValidator.message");
			}
		}

	}

}
