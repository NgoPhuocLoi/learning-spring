package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.*;
import com.example.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        // Using @Bean annotation
        Vehicle v1 = new Vehicle();
        v1.setName("Honda City");
        System.out.println("Vehicle name from non-spring context is:: " + v1.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle v2 = context.getBean("vehicleHasName", Vehicle.class);
        System.out.println("Vehicle name from spring context:: " + v2.getName());

        Vehicle primaryVeh = context.getBean(Vehicle.class);
        System.out.println("Primary vehicle:: " + primaryVeh.getName());

        String hello = context.getBean(String.class);
        System.out.println("String value from the Spring Context:: " + hello);

        int number = (int) context.getBean("number");
        System.out.println("Number value from the Spring Context:: " + number);

        // Using @Component and @ComponentScan
        Dog d1 = context.getBean(Dog.class);
        System.out.println("Dog is got from the Spring with @Component :: " + d1.getName());
        d1.sayHi();

        context.close();
    }
}