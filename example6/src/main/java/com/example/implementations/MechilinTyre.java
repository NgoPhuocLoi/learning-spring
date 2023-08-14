package com.example.implementations;

import org.springframework.stereotype.Component;

import com.example.interfaces.Tyres;

@Component
public class MechilinTyre implements Tyres {
    public void rotate() {
        System.out.println("Mechilin tyre is rotating ...!");
    }
}
