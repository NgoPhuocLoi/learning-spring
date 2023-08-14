package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.*;
import com.example.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Dog d = context.getBean("d1", Dog.class);
        People p1 = context.getBean("p1", People.class);

        System.out.println("Dog's name:: " + d.getName());
        System.out.println("People1's name:: " + p1.getName());
        System.out.println("Dog that people1 owns:: " + p1.getDog());

        People p2 = context.getBean("p2", People.class);
        System.out.println("People2's name:: " + p2.getName());
        System.out.println("Dog that people2 owns:: " + p2.getDog());

        context.close();
    }
}