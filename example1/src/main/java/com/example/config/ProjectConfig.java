package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.beans.Vehicle;

@Configuration
@ComponentScan(basePackages = "com.example.beans")
public class ProjectConfig {

    @Primary
    @Bean
    Vehicle vehicle() {
        var v = new Vehicle();
        v.setName("Audi 8");
        return v;
    }

    @Bean(name = "vehicleHasName")
    Vehicle vehicleWithName() {
        var v = new Vehicle();
        v.setName("Vehicle has name!");
        return v;
    }

    @Bean
    String hello() {
        return "Hello World!";
    }

    @Bean
    int number() {
        return 22;
    }
}
