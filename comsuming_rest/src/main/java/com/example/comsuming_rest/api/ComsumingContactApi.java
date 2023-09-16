package com.example.comsuming_rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.comsuming_rest.models.Contact;
import com.example.comsuming_rest.models.Response;
import com.example.comsuming_rest.proxy.ContactProxy;

import reactor.core.publisher.Mono;

@RestController
public class ComsumingContactApi {

    @Autowired
    ContactProxy contactProxy;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient webClientl;

    @GetMapping("/messages")
    public List<Contact> getMessages(@RequestParam(defaultValue = "OPEN") String status) {
        return contactProxy.getMessagesByStatus(status);
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMessageWithRestTemplate(@RequestBody Contact contact) {
        final String url = "http://localhost:8080/api/contact/saveMsg";
        HttpHeaders headers = new HttpHeaders();
        headers.add("invocationFrom", "REST_TEMPLATE");
        HttpEntity<Contact> HttpEntity = new HttpEntity<>(contact, headers);
        ResponseEntity<com.example.comsuming_rest.models.Response> responseEntity = restTemplate.exchange(url,
                HttpMethod.POST, HttpEntity, com.example.comsuming_rest.models.Response.class);
        return responseEntity;
    }

    @PostMapping("/saveMessage")
    public Mono<Response> saveMessageWithWebClient(@RequestBody Contact contact) {
        final String uri = "http://localhost:8080/api/contact/saveMsg";

        return webClientl.post().uri(uri).header("invocationFrom", "WEB_CLIENT").body(Mono.just(contact), Contact.class)
                .retrieve().bodyToMono(Response.class);
    }
}
