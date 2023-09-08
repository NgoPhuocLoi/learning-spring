package com.example.easy_school_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.easy_school_app.models.Person;
import com.example.easy_school_app.services.PersonService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("public")
public class PublicController {
    @Autowired
    PersonService personService;

    @GetMapping("/register")
    public String displayRegisterPage(Model model) {
        model.addAttribute("person", new Person());
        return "register.html";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {
        if (errors.hasErrors())
            return "register.html";

        boolean saved = personService.savePerson(person);

        if (saved)
            return "redirect:/login?register=true";

        return "register.html";
    }
}
