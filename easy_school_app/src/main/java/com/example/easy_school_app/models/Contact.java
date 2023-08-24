package com.example.easy_school_app.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Contact {
    @NotBlank(message = "Name must not be blank")
    @Min(3)
    private String name;

    @NotBlank(message = "ABC")
    private String mobileNum;
    private String email;
    private String subject;
    private String message;

}
