package com.example;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Animal;
import com.example.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Animal dog = new Animal();
        dog.setType("Dog");
        Supplier<Animal> dogSupplier = () -> dog;

        Supplier<Animal> catSupplier = () -> {
            Animal cat = new Animal();
            cat.setType("Cat");
            return cat;
        };

        Random r = new Random();
        int num = r.nextInt(10);

        if (num % 2 == 0) {
            context.registerBean("dogBean", Animal.class, dogSupplier);
        } else {
            context.registerBean("catBean", Animal.class, catSupplier);
        }

        Animal catBean = null;
        Animal dogBean = null;

        try {
            dogBean = context.getBean("dogBean", Animal.class);
            System.out.println("The type of animal:: " + dogBean.getType());
        } catch (NoSuchBeanDefinitionException e) {
            // TODO: handle NoSuchBeanDefinitionException
            System.err.println("Error when creating dog bean");
        }

        try {
            catBean = context.getBean("catBean", Animal.class);
            System.out.println("The type of animal:: " + catBean.getType());
        } catch (NoSuchBeanDefinitionException e) {
            // TODO: handle exception
            System.err.println("Error when creating cat bean");
        }

        context.close();
    }
}