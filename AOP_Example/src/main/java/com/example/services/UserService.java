package com.example.services;

import org.springframework.stereotype.Component;

import com.example.annotations.LogAspect;
import com.example.beans.User;

@Component

public class UserService {

    public void getUsers() {
        System.out.println("User list = [.....]");
    }

    public User createUser(String username, int age) {
        System.out.println("Before create user ....");
        User user = new User();
        System.out.println("name:: " + username);
        user.setAge((int) age);
        user.setName((String) username);
        System.out.println("After create user ...");
        return user;
    }

    @LogAspect
    public boolean deleteUser(String role) {
        if (!role.equals("Admin")) {
            System.err.println("Pemission denied!");
            return false;
        }
        System.out.println("User is deleted!");
        return true;
    }
}
