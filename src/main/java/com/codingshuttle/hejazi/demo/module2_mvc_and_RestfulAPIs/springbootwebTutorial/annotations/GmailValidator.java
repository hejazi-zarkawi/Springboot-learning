package com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GmailValidator implements ConstraintValidator<ValidGmail, String> {

    private static final String GMAIL_REGEX =
            "^[A-Za-z0-9._%+-]+@gmail\\.com$";
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value==null){
            return true;
        }

        return value.matches(GMAIL_REGEX);
    }
}
