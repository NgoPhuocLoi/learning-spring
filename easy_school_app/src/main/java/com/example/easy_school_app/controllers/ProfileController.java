package com.example.easy_school_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.easy_school_app.models.Address;
import com.example.easy_school_app.models.Person;
import com.example.easy_school_app.models.Profile;
import com.example.easy_school_app.repositories.PersonRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProfileController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/displayProfile")
    public String displayProfile(Model model, HttpSession session) {
        Profile profile = new Profile();
        Person person = (Person) session.getAttribute("loggedInPerson");

        profile.setName(person.getName());
        profile.setEmail(person.getEmail());
        profile.setMobileNumber(person.getMobileNumber());
        if (person.getAddess() != null) {
            profile.setAddress1(person.getAddess().getAddress1());
            profile.setAddress2(person.getAddess().getAddress2());
            profile.setCity(person.getAddess().getCity());
            profile.setState(person.getAddess().getState());
            profile.setZipCode(person.getAddess().getZipCode());
        }

        model.addAttribute("profile", profile);
        return "profile.html";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, Errors errors,
            HttpSession httpSession) {
        if (errors.hasErrors()) {
            return "profile.html";
        }
        Person person = (Person) httpSession.getAttribute("loggedInPerson");
        person.setName(profile.getName());
        person.setMobileNumber(profile.getMobileNumber());

        if (person.getAddess() == null) {
            person.setAddess(new Address());
        }

        person.getAddess().setAddress1(profile.getAddress1());
        person.getAddess().setAddress2(profile.getAddress2());
        person.getAddess().setCity(profile.getCity());
        person.getAddess().setState(profile.getState());
        person.getAddess().setZipCode(profile.getZipCode());

        personRepository.save(person);
        httpSession.setAttribute("loggedInPerson", person);
        return "redirect:/displayProfile";
    }
}
