package com.example.easy_school_app.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.easy_school_app.constants.ContactConstant;
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

    public boolean saveMessageToDB(Contact contact) {
        contact.setStatus(ContactConstant.OPEN);
        contact.setCreatedBy(ContactConstant.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = this.contactRepo.insertContact(contact);
        return result > 0;
    }

    public List<Contact> getOpennedMessages() {
        var results = this.contactRepo.getMessagesByStatus(ContactConstant.OPEN);
        System.out.println(results);
        return results;
    }

    public boolean updateMessageStatus(int id, String updatedPerson) {
        System.out.println("Here");
        int result = this.contactRepo.updateMessageStatus(id, updatedPerson, ContactConstant.CLOSED);
        return result > 0;
    }
}
