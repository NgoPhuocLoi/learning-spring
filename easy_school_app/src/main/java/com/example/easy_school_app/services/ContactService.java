package com.example.easy_school_app.services;

import org.springframework.stereotype.Service;

import com.example.easy_school_app.models.Contact;

@Service
// @SessionScope
public class ContactService {

    public ContactService() {
        System.out.println("Contact service is created!");
    }

    public boolean saveMessageToDB(Contact contact) {
        boolean isSaved = true;
        System.out.println("Message from ContactService: Contact data is saved!");
        System.out.println(contact);
        return isSaved;
    }
}
