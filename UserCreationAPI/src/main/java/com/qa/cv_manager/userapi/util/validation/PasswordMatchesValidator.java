package com.qa.cv_manager.userapi.util.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.qa.cv_manager.userapi.persistence.domain.UserPOJO;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {}
	
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserPOJO user = (UserPOJO) obj;
		return user.getPassword().equals(user.getConfirmPassword());
	}
}
