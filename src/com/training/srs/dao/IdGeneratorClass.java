package com.training.srs.dao;

import java.util.UUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdGeneratorClass implements ConstraintValidator<IdGeneratorAnnotation, String>{

	@Override
	public void initialize(IdGeneratorAnnotation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		
		return false;
	}

	

}
