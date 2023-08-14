package com.example.implementations;

import org.springframework.stereotype.Component;

import com.example.interfaces.Speaker;

@Component("boseSpeaker")
public class BoseSpeaker implements Speaker {

    public BoseSpeaker() {
        System.out.println("BoseSpeaker was created!");
    }

    public void makeSound() {
        System.out.println("Bose speaker make sound...");
    }
}
