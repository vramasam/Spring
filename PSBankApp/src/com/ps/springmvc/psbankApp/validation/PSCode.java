package com.ps.springmvc.psbankApp.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.springframework.messaging.handler.annotation.Payload;

/**
 * Class that defines the custom annotation
 * @author vivekramasamy
 *
 */
@Constraint(validatedBy=PSCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PSCode {
	public String value() default "PS";
	
	public String message() default "PS Code Should be Start with PS";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
	
}
