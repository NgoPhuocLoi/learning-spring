package com.example.easy_school_app.validations;

import com.example.easy_school_app.annotations.PasswordValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Arrays;

public class PasswordStrengthVadilator implements ConstraintValidator<PasswordValidator, String> {

    private List<String> weakPasswords;

    @Override
    public void initialize(PasswordValidator passwordValidator) {
        weakPasswords = Arrays.asList("12345", "password", "qwert");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("value:: " + value);
        // TODO Auto-generated method stub
        return value != null && !weakPasswords.contains(value);
    }

}
