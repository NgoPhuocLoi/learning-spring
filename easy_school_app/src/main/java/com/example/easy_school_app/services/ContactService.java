package com.example.easy_school_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.easy_school_app.constants.AppConstant;
import com.example.easy_school_app.models.Contact;
import com.example.easy_school_app.repositories.ContactRepositoryJPA;

@Service
// @SessionScope
public class ContactService {
    // @Autowired
    // ContactRepo contactRepo;

    @Autowired
    private ContactRepositoryJPA contactRepositoryJPA;

    // public boolean saveMessageToDB(Contact contact) {
    // contact.setStatus(ContactConstant.OPEN);
    // contact.setCreatedBy(ContactConstant.ANONYMOUS);
    // contact.setCreatedAt(LocalDateTime.now());
    // int result = this.contactRepo.insertContact(contact);
    // return result > 0;
    // }

    // public List<Contact> getOpennedMessages() {
    // var results = this.contactRepo.getMessagesByStatus(ContactConstant.OPEN);
    // System.out.println(results);
    // return results;
    // }

    // public boolean updateMessageStatus(int id, String updatedPerson) {
    // System.out.println("Here");
    // int result = this.contactRepo.updateMessageStatus(id, updatedPerson,
    // ContactConstant.CLOSED);
    // return result > 0;
    // }

    public boolean saveMessageToDB(Contact contact) {
        contact.setStatus(AppConstant.OPEN);
        Contact savedContact = this.contactRepositoryJPA.save(contact);
        return (savedContact != null && savedContact.getContactId() > 0);
    }

    public Page<Contact> getOpennedMessages(Pageable pageable) {
        // var contacts = this.contactRepositoryJPA.findByStatus(AppConstant.OPEN,
        // pageable);
        var contacts = this.contactRepositoryJPA.findContactWithStatusCustomNamedQuery(AppConstant.OPEN, pageable);

        return contacts;
    }

    public boolean updateMessageStatus(int id) {
        // Optional<Contact> contact = this.contactRepositoryJPA.findById(id);
        // contact.ifPresent(c -> {
        // c.setStatus(AppConstant.CLOSED);
        // });

        // Contact updatedContact = this.contactRepositoryJPA.save(contact.get());
        int result = contactRepositoryJPA.updateContactStatusById(id, AppConstant.CLOSED);
        return result > 0;
    }
}
