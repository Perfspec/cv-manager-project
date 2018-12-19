package com.qa.cv_manager.usercreationapi.util.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.qa.cv_manager.usercreationapi.util.constants.Constants;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPasswordValidator.class)
@Documented
public @interface ValidPassword {
	String message() default Constants.INVALID_PASSWORD_ERROR;
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
