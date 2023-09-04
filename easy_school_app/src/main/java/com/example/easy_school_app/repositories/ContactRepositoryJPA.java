package com.example.easy_school_app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.easy_school_app.models.Contact;

import java.util.List;

@Repository
public interface ContactRepositoryJPA extends CrudRepository<Contact, Integer> {

    public List<Contact> findByStatus(String status);
}
