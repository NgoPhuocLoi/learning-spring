package com.example.easy_school_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easy_school_app.models.Classroom;

@Repository
public interface ClassRepository extends JpaRepository<Classroom, Integer> {

}
