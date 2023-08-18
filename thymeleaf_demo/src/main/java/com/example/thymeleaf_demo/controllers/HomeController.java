package com.example.thymeleaf_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String displayHome(Model model) {
        model.addAttribute("username", "Loi Ngo");

        return "home.html";
    }
}
