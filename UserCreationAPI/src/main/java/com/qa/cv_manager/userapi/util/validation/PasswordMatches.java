package com.qa.cv_manager.userapi.util.validation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.qa.cv_manager.userapi.util.constants.Constants;



@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
	String message() default Constants.PASSWORD_MATCHES_ERROR;
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}