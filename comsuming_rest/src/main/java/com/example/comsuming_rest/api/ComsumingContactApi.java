package com.example.comsuming_rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.comsuming_rest.models.Contact;
import com.example.comsuming_rest.proxy.ContactProxy;

@RestController
public class ComsumingContactApi {

    @Autowired
    ContactProxy contactProxy;

    @GetMapping("/messages")
    public List<Contact> getMessages(@RequestParam(defaultValue = "OPEN") String status) {
        return contactProxy.getMessagesByStatus(status);
    }
}
