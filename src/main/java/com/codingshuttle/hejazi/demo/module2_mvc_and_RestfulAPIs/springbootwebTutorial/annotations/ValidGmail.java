package com.codingshuttle.hejazi.demo.module2_mvc_and_RestfulAPIs.springbootwebTutorial.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = {GmailValidator.class})
public @interface ValidGmail {

    String message() default "Email should have a gmail address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
