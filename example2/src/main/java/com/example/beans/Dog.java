package com.example.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Dog {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void initialize() {
        this.name = "Kiki";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Context was destroyed!");
    }

}
