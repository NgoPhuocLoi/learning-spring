package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.User;
import com.example.config.ProjectConfig;
import com.example.services.UserService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        UserService userService = context.getBean(UserService.class);
        User u1 = userService.createUser("Phuoc Loi", 19);

        try {
            boolean status = userService.deleteUser("Admin");
        } catch (Exception e) {
            // TODO: handle exception
        }

        userService.getUsers();
        context.close();
    }
}