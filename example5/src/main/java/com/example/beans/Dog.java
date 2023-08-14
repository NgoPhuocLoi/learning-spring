package com.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    private String name = "Kki";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog name - " + getName();
    }
}
