package com.example.comsuming_rest.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.comsuming_rest.config.ProjectConfig;
import com.example.comsuming_rest.models.Contact;

import feign.Headers;

@FeignClient(name = "contact", url = "http://localhost:8080/api/contact", configuration = ProjectConfig.class)
public interface ContactProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/messages")
    @Headers(value = "Content-Type: application/json")
    public List<Contact> getMessagesByStatus(@RequestParam String status);
}
