package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.beans.*;

@Configuration
public class ProjectConfig {

    @Bean("d1")
    public Dog dog() {
        Dog d = new Dog();
        d.setName("Kiki");
        return d;
    }

    @Bean("d2")
    @Primary
    public Dog dog2() {
        Dog d = new Dog();
        d.setName("GauGau");
        return d;
    }

    // Wiring by method call
    @Bean("p1")
    public People people() {
        People p = new People();
        p.setName("Loi");
        p.setDog(dog());
        return p;
    }

    // Wiring by method parameters (parameter must be the unique bean)
    @Bean("p2")
    public People people2(Dog d) {
        People p = new People();
        p.setName("People 2");
        p.setDog(d);
        return p;
    }
}
