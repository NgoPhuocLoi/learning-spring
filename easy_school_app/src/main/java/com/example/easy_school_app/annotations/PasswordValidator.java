package com.example.easy_school_app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.easy_school_app.validations.PasswordStrengthVadilator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PasswordStrengthVadilator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface PasswordValidator {
    String message() default "Please choose a stronger password!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
