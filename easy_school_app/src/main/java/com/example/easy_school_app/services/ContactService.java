package com.example.easy_school_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easy_school_app.models.Contact;
import com.example.easy_school_app.repositories.ContactRepo;

@Service
// @SessionScope
public class ContactService {
    ContactRepo contactRepo;

    @Autowired
    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public ContactService() {
        System.out.println("Contact service is created!");
    }

    public int saveMessageToDB(Contact contact) {
        int isSaved = this.contactRepo.getRow();
        System.out.println("Row: " + isSaved);
        System.out.println("Message from ContactService: Contact data is saved!");
        System.out.println(contact);
        return isSaved;
    }
}
