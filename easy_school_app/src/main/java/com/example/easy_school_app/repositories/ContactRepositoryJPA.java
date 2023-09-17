package com.example.easy_school_app.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.easy_school_app.models.Contact;

import jakarta.transaction.Transactional;

@Repository
@RepositoryRestResource(path = "courses")
public interface ContactRepositoryJPA extends JpaRepository<Contact, Integer> {

    public List<Contact> findByStatus(String status);

    // public Page<Contact> findByStatus(String status, Pageable pageable);

    @Query("SELECT c FROM Contact c WHERE c.status = :status")
    public Page<Contact> findByStatusCustomJPQL(String status, Pageable pageable);

    @Query(value = "SELECT * FROM contact_msg WHERE status = :status", nativeQuery = true)
    public List<Contact> findByStatusCustomSQL(String status);

    @Query("UPDATE Contact c SET c.status = :status WHERE c.contactId = :contactId")
    @Modifying
    @Transactional
    public int updateContactStatusById(int contactId, String status);

    public List<Contact> findContactWithStatusCustomNamedQuery(String status);
}
