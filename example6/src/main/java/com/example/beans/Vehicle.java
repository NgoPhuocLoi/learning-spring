package com.example.beans;

import org.springframework.stereotype.Component;

import com.example.services.VehicleService;

@Component
public class Vehicle {
    private String name;

    private final VehicleService vs;

    public Vehicle(VehicleService vs) {
        this.vs = vs;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleService getVs() {
        return this.vs;
    }

}
