package com.training.srs.dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=IdGeneratorClass.class)
public @interface IdGeneratorAnnotation {
	String message() default "Name should start with capital letter";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
		
		 
		
}
