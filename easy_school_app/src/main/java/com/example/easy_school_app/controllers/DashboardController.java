package com.example.easy_school_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.easy_school_app.config.EasySchoolProperties;
import com.example.easy_school_app.models.Person;
import com.example.easy_school_app.repositories.PersonRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

    @Value("${easy-school.defaultPageSize}")
    private int defaultPageSize;

    @Value("${easy-school.contact.successMsg}")
    private String successMessage;

    @Autowired
    private Environment environment;

    @Autowired
    private EasySchoolProperties easySchoolProperties;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session) {
        Person person = personRepository.findByEmail(authentication.getName());
        String username = person.getName();
        String roles = authentication.getAuthorities().toString();
        model.addAttribute("username", username);
        model.addAttribute("roles", roles);

        session.setAttribute("loggedInPerson", person);
        if (person.getClassroom() != null && person.getClassroom().getName() != null) {
            model.addAttribute("enrolledClass", person.getClassroom().getName());
        }
        // throw new RuntimeException("This is a deliberate exception thrown to check
        // the exception handler :>!");
        logProperties();
        return "dashboard.html";
    }

    private void logProperties() {
        System.out.println("Default page size from @Value: " + defaultPageSize);
        System.out.println("Success message from @Value: " + successMessage);
        System.out.println("Default page size from Environment interface: "
                + environment.getProperty("easy-school.defaultPageSize"));
        System.out.println("Success message from Environment interface: "
                + environment.getProperty("easy-school.contact.successMsg"));
        System.out.println("Properties from @ConfigurationProperties :: " + easySchoolProperties);
    }
}
