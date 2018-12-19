package com.qa.cv_manager.usercreationapi.util.validation;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.CharacterCharacteristicsRule;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;

public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String> {

	@Override
	public void initialize(ValidPassword constraintAnnotation) {}
	
	public boolean isValid(String password, ConstraintValidatorContext context) {
		PasswordValidator validator = new PasswordValidator(Arrays.asList(
		           new LengthRule(8, 60),
		           new CharacterCharacteristicsRule(3,
		        	new CharacterRule(EnglishCharacterData.LowerCase), 
		           	new CharacterRule(EnglishCharacterData.UpperCase), 
		        	new CharacterRule(EnglishCharacterData.Digit),
		        	new CharacterRule(EnglishCharacterData.Special) )));
		
		return validator.validate(new PasswordData(password)).isValid();
	}
}
