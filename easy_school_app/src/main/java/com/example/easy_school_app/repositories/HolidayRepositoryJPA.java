package com.example.easy_school_app.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.easy_school_app.models.Holiday;

@Repository
public interface HolidayRepositoryJPA extends ListCrudRepository<Holiday, String> {

}
