package com.example.easy_school_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.easy_school_app.models.Person;
import com.example.easy_school_app.repositories.PersonRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session) {
        Person person = personRepository.findByEmail(authentication.getName());
        String username = person.getName();
        String roles = authentication.getAuthorities().toString();
        model.addAttribute("username", username);
        model.addAttribute("roles", roles);

        session.setAttribute("loggedInPerson", person);
        // throw new RuntimeException("This is a deliberate exception thrown to check
        // the exception handler :>!");
        return "dashboard.html";
    }
}
