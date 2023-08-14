package com.example.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.interfaces.Tyres;

@Component
@Primary
public class BridgeStoneTyre implements Tyres {
    public void rotate() {
        System.out.println("BridgeStone Tyre is rotating  ...!");
    }
}
