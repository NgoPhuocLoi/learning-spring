package com.example.comsuming_rest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class Contact extends BaseEntity {

    private int contactId;
    private String name;

    private String mobileNum;
    private String email;
    private String subject;
    private String message;
    private String status;

}
