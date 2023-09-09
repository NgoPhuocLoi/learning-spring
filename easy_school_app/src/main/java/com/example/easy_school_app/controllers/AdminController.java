package com.example.easy_school_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.easy_school_app.models.Classroom;
import com.example.easy_school_app.models.Person;
import com.example.easy_school_app.repositories.ClassRepository;
import com.example.easy_school_app.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/displayClasses")
    public String displayClasses(Model model) {
        Classroom classroom = new Classroom();
        List<Classroom> classrooms = classRepository.findAll();
        model.addAttribute("classroom", classroom);
        model.addAttribute("classes", classrooms);
        return "classes.html";
    }

    @PostMapping("/addNewClass")
    public String addNewClass(@Valid @ModelAttribute("classroom") Classroom classroom, Errors errors) {
        if (errors.hasErrors()) {
            return "classes.html";
        }
        classRepository.save(classroom);
        return "redirect:/admin/displayClasses";
    }

    @RequestMapping("/deleteClass")
    public String deleteClass(@RequestParam int id) {
        Optional<Classroom> cls = classRepository.findById(id);
        for (Person p : cls.get().getPersons()) {
            p.setClassroom(null);
            personRepository.save(p);
        }
        classRepository.deleteById(id);
        return "redirect:/admin/displayClasses";
    }
}
