package com.example.easy_school_app.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Contact extends BaseEntity {
    private int contactId;
    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "ABC")
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
    private String status;

}
