package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class People {
    private String name = "Loi";
    // @Autowired
    private Dog dog;

    @Autowired // @Autowired is optional
    public People(Dog d) {
        this.dog = d;
    }

    public String getName() {
        return this.name;
    }

    // @Autowired
    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return this.dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

}
