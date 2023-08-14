package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.*;
import com.example.config.ProjectConfig;

interface PrintLambda {
    void print();
}

interface DoubleString {
    String db(String s);
}

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle v1 = context.getBean(Vehicle.class);
        System.out.println("Vehicle name:: " + v1.getName());
        v1.running();

        Dog d = context.getBean(Dog.class);
        System.out.println("Dog's name:: " + d.getName());

        context.close();
    }
}