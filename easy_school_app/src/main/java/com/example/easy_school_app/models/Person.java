package com.example.easy_school_app.models;

import org.hibernate.annotations.GenericGenerator;

import com.example.easy_school_app.annotations.PasswordValidator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int personId;

    @NotBlank(message = "Name must not be blank!")
    @Min(value = 3, message = "Name must be at least 3 characters long")
    private String name;
    private String mobileNumber;
    private String email;
    private String confirmEmail;
    @NotBlank(message = "Password must not be blank!")
    @PasswordValidator(message = "Please choose a stronger password!")
    private String pwd;
    private String confirmPwd;
}
