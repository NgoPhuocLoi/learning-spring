package com.example.easy_school_app.controllers;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @RequestMapping(value = "/contact")
    public String displayContactPage() {
        return "contact.html";
    }

    // @RequestMapping(value = "/saveMsg", method = POST)
    @PostMapping(value = "/saveMsg")
    public ModelAndView handleSaveMessage(@RequestParam(required = true, name = "name") String name,
            @RequestParam String mobileNum) {
        System.out.println("Hello");
        System.out.println("name: " + name);
        System.out.println("mobileNum: " + mobileNum);
        return new ModelAndView("redirect:/contact");
    }
}
