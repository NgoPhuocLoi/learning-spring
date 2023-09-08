package com.example.easy_school_app.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Profile {
    @NotBlank(message = "Name must not be blank!")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Address1 must not be blank!")
    private String address1;

    private String address2;

    @NotBlank(message = "City must not be blank!")
    private String city;

    @NotBlank(message = "State must not be blank!")
    private String state;

    @NotBlank(message = "Zipcode must not be blank!")
    private String zipCode;
}
