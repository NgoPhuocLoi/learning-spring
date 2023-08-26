package com.example.easy_school_app.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication) {
        System.out.println(authentication.getCredentials());
        String username = authentication.getName();
        String roles = authentication.getAuthorities().toString();
        model.addAttribute("username", username);
        model.addAttribute("roles", roles);
        return "dashboard.html";
    }
}
