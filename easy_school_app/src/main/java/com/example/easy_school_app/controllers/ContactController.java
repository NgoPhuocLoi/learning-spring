package com.example.easy_school_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.easy_school_app.models.Contact;
import com.example.easy_school_app.services.ContactService;

@Controller
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/contact")
    public String displayContactPage() {
        return "contact.html";
    }

    // @RequestMapping(value = "/saveMsg", method = POST)
    // @PostMapping(value = "/saveMsg")
    // public ModelAndView handleSaveMessage(@RequestParam(required = true, name =
    // "name") String name,
    // @RequestParam String mobileNum) {
    // System.out.println("Hello");
    // System.out.println("name: " + name);
    // System.out.println("mobileNum: " + mobileNum);
    // return new ModelAndView("redirect:/contact");
    // }

    // using POJO class to handle Request Params
    @PostMapping(value = "/saveMsg")
    public ModelAndView handleSaveMessage(Contact contact) {
        contactService.saveMessageToDB(contact);
        return new ModelAndView("redirect:/contact");
    }
}
