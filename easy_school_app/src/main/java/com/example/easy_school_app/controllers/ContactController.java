package com.example.easy_school_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.easy_school_app.models.Contact;
import com.example.easy_school_app.services.ContactService;

import jakarta.validation.Valid;

@Controller
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    /*
     * @RequestMapping(value = "/saveMsg",method = POST)
     * public ModelAndView saveMessage(@RequestParam String name, @RequestParam
     * String mobileNum,
     * 
     * @RequestParam String email, @RequestParam String subject, @RequestParam
     * String message) {
     * log.info("Name : " + name);
     * log.info("Mobile Number : " + mobileNum);
     * log.info("Email Address : " + email);
     * log.info("Subject : " + subject);
     * log.info("Message : " + message);
     * return new ModelAndView("redirect:/contact");
     * }
     */

    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {

        if (errors.hasErrors()) {
            // System.out.println(errors);
            return "contact.html";
        }
        contactService.saveMessageToDB(contact);
        return "redirect:/contact";
    }

    @GetMapping("/displayMessages")
    public String displayMessages(Model model) {
        var results = this.contactService.getOpennedMessages();
        model.addAttribute("contactMsgs", results);
        return "messages.html";
    }

    @GetMapping("/closeMsg")
    public String closeMessage(@RequestParam int id, Authentication authentication) {
        System.out.println(authentication.getName());
        this.contactService.updateMessageStatus(id, authentication.getName());
        return "redirect:/displayMessages";
    }
}
