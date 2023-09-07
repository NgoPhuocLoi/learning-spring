package com.example.easy_school_app.validations;

import org.springframework.beans.BeanWrapperImpl;

import com.example.easy_school_app.annotations.FieldsValueMatch;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldsMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {

    private String field, fieldMatch;

    @Override
    public void initialize(FieldsValueMatch fieldsValueMatch) {
        this.field = fieldsValueMatch.field();
        this.fieldMatch = fieldsValueMatch.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        var bean = new BeanWrapperImpl(value);
        Object fieldValue = bean.getPropertyValue(this.field);
        Object fieldMatchValue = bean.getPropertyValue(this.fieldMatch);
        if (fieldValue == null || fieldMatchValue == null)
            return false;
        return fieldValue.equals(fieldMatchValue);
    }

}
