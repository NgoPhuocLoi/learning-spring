package com.example.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.interfaces.Speaker;

@Component("sonySpeaker")
@Primary
public class SonySpeaker implements Speaker {

    public SonySpeaker() {
        System.out.println("SonySpeaker was created@");
    }

    public void makeSound() {
        System.out.println("Sony speaker make sound...");
    }

}
