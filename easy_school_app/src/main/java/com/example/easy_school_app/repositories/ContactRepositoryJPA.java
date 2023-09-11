package com.example.easy_school_app.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easy_school_app.models.Contact;

@Repository
public interface ContactRepositoryJPA extends JpaRepository<Contact, Integer> {

    public List<Contact> findByStatus(String status);

    public Page<Contact> findByStatus(String status, Pageable pageable);
}
