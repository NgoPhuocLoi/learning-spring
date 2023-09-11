package com.example.easy_school_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.easy_school_app.models.Person;
import com.example.easy_school_app.repositories.CoursesRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    CoursesRepository coursesRepository;

    @GetMapping("/displayCourses")
    public String displayCourses(Model model, HttpSession httpSession) {
        Person loggedInPerson = (Person) httpSession.getAttribute("loggedInPerson");
        System.out.println("COursessssssssss :::: " + loggedInPerson.getCourses());
        model.addAttribute("person", loggedInPerson);
        return "courses_enrolled.html";
    }
}
