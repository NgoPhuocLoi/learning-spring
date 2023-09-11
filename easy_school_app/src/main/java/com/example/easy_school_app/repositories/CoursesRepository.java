package com.example.easy_school_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.easy_school_app.models.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {
}
