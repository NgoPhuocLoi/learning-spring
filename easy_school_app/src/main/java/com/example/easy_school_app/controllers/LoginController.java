package com.example.easy_school_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public String displayLoginPage(@RequestParam(required = false) boolean error,
            @RequestParam(required = false) boolean logout, Model model) {
        String message = "";
        if (error) {
            message = "Username or password is incorrect!";
        }

        if (logout) {
            message = "Lougout successfully!";
        }
        model.addAttribute("message", message);
        return "login.html";
    }
}
