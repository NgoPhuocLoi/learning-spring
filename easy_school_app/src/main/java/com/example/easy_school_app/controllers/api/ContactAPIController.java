package com.example.easy_school_app.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.easy_school_app.models.Contact;
import com.example.easy_school_app.models.Response;
import com.example.easy_school_app.repositories.ContactRepositoryJPA;

import jakarta.validation.Valid;

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

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestHeader String invocationFrom, @Valid @RequestBody Contact contact) {
        System.out.println("Invocation from: " + invocationFrom);
        contactRepositoryJPA.save(contact);
        Response response = new Response();
        response.setStatusCode("200");
        response.setMessage("Message saved successfully!");
        return ResponseEntity.status(HttpStatus.CREATED).header("isSaved", "true").body(response);
    }

    @DeleteMapping("/deleteMsg")
    public ResponseEntity<Response> deleteMsg(RequestEntity<Contact> requestEntity) {
        HttpHeaders httpHeaders = requestEntity.getHeaders();
        httpHeaders.forEach((key, value) -> {
            System.out.print(key + ":: ");
            System.out.println(value);
        });
        Contact contact = requestEntity.getBody();
        contactRepositoryJPA.deleteById(contact.getContactId());
        Response response = new Response("200", "Message was deleted!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
