package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Person;
import com.example.config.ProjectConfig;
import com.example.interfaces.Speaker;
import com.example.services.VehicleService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Speaker bs = context.getBean("boseSpeaker", Speaker.class);
        Person p = context.getBean(Person.class);
        VehicleService vs = context.getBean(VehicleService.class);
        vs.setSpeaker(bs);
        p.getVehicle().getVs().operate();

        context.close();
    }
}