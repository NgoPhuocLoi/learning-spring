package com.example.easy_school_app.models;

import org.hibernate.annotations.GenericGenerator;

import com.example.easy_school_app.annotations.FieldsValueMatch;
import com.example.easy_school_app.annotations.PasswordValidator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@FieldsValueMatch.List({
        @FieldsValueMatch(field = "pwd", fieldMatch = "confirmPwd", message = "Password don't match"),
        @FieldsValueMatch(field = "email", fieldMatch = "confirmEmail", message = "Email don't match"),
})

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int personId;

    @NotBlank(message = "Name must not be blank!")
    @Min(value = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Email(message = "Invalid email address")
    private String email;
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank!")
    @PasswordValidator(message = "Please choose a stronger password!")
    private String pwd;
    private String confirmPwd;
}
