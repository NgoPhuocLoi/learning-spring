package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.interfaces.Speaker;
import com.example.interfaces.Tyres;

@Component
public class VehicleService {
    @Autowired
    private Speaker speaker;
    @Autowired
    private Tyres tyre;

    public Tyres getTyre() {
        return this.tyre;
    }

    public void setTyre(Tyres tyre) {
        this.tyre = tyre;
    }

    public VehicleService(Speaker p) {
        this.speaker = p;
    }

    public Speaker getSpeaker() {
        return this.speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public void operate() {
        speaker.makeSound();
        tyre.rotate();
    }
}
