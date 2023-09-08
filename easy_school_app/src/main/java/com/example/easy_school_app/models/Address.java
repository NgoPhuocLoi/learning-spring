package com.example.easy_school_app.models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int addressId;

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
