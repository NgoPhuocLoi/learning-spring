package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.*;
import com.example.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Dog d = context.getBean(Dog.class);
        People p = context.getBean(People.class);

        System.out.println("Dog's name:: " + d.getName());
        System.out.println("People's name:: " + p.getName());
        System.out.println("Dog that people owns:: " + p.getDog());

        context.close();
    }
}