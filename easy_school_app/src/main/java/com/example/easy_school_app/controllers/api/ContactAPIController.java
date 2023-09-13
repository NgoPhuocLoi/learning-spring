package com.example.easy_school_app.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.easy_school_app.models.Contact;
import com.example.easy_school_app.repositories.ContactRepositoryJPA;

@RestController
@RequestMapping("api/contact")
public class ContactAPIController {

    @Autowired
    ContactRepositoryJPA contactRepositoryJPA;

    @GetMapping("/messages")
    // @ResponseBody
    public List<Contact> getMessagesByStatus(@RequestParam String status) {
        return contactRepositoryJPA.findByStatus(status);
    }

    @GetMapping("/messages_with_body")
    // @ResponseBody
    public List<Contact> getMessagesByStatusWithBody(@RequestBody Contact contact) {
        if (contact == null || contact.getStatus() == null)
            return List.of();
        return contactRepositoryJPA.findByStatus(contact.getStatus());
    }
}
