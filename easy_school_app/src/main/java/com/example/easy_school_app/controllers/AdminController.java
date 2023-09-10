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

import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/displayStudents")
    public String displayStudents(Model model, @RequestParam int classId, @RequestParam(required = false) boolean error,
            HttpSession httpSession) {
        Optional<Classroom> cls = classRepository.findById(classId);
        model.addAttribute("person", new Person());
        model.addAttribute("class", cls.get());
        httpSession.setAttribute("currentCls", cls.get());

        if (error) {
            model.addAttribute("errorMessage", "Student with this is email was not existed!");
        }

        return "students.html";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("person") Person person, Errors errors, Model model,
            HttpSession httpSession) {
        Classroom currentCls = (Classroom) httpSession.getAttribute("currentCls");
        // if (errors.hasErrors())
        // return "redirect:/admin/displayStudents?classId=" + currentCls.getClassId() +
        // "&error=true";
        Person student = personRepository.findByEmail(person.getEmail());
        System.out.println("Email:: " + person.getEmail());
        System.out.println("Email:: " + student);

        if (student == null) {
            return "redirect:/admin/displayStudents?classId=" + currentCls.getClassId() +
                    "&error=true";
        }

        student.setClassroom(currentCls);
        personRepository.save(student);
        currentCls.getPersons().add(student);
        classRepository.save(currentCls);
        return "redirect:/admin/displayStudents?classId=" + currentCls.getClassId();
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam int personId, HttpSession session) {
        Optional<Person> student = personRepository.findById(personId);
        Classroom currentCls = (Classroom) session.getAttribute("currentCls");
        student.get().setClassroom(null);
        personRepository.save(student.get());
        currentCls.getPersons().remove(student.get());
        classRepository.save(currentCls);
        return "redirect:/admin/displayStudents?classId=" + currentCls.getClassId();
    }

}
