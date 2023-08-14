package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.*;
import com.example.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        System.out.println("Before the context is created!");
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Singleton scope and @Lazy instatitation
        System.out.println("Before the person bean is used!");
        Person p1 = context.getBean(Person.class);
        Person p2 = context.getBean("person", Person.class);
        System.out.println("Person1's name :: " + p1.getName());
        System.out.println("Person2's name :: " + p2.getName());

        p1.setName("Ngo Phuoc Loi");
        System.out.println("Person1's name :: " + p1.getName());
        System.out.println("Person2's name :: " + p2.getName());

        // Prototype scope

        Dog d1 = context.getBean(Dog.class);
        Dog d2 = context.getBean("dog", Dog.class);
        System.out.println("Dog1's name :: " + d1.getName());
        System.out.println("Dog2's name :: " + d2.getName());

        d1.setName("Meo Meo");
        System.out.println("Dog1's name :: " + d1.getName());
        System.out.println("Dog2's name :: " + d2.getName());
        context.close();
    }
}