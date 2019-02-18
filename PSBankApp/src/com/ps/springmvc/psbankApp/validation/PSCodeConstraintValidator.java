package com.ps.springmvc.psbankApp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Class that helps in validation the custom annotation and gives the result
 * @author vivekramasamy
 *
 */
public class PSCodeConstraintValidator implements ConstraintValidator<PSCode, String> {
	
	public String codePrefix;
	
	@Override
	public void initialize(PSCode code) {
		codePrefix = code.value();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext arg1) {
		boolean result;
		
		if(code != null) {
			result = code.startsWith(codePrefix);
		} else {
			result = true;
		}
		return result;
	}

}
