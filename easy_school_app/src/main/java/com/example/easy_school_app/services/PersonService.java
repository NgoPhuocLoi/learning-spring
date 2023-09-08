package com.example.easy_school_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easy_school_app.constants.AppConstant;
import com.example.easy_school_app.models.Person;
import com.example.easy_school_app.models.Roles;
import com.example.easy_school_app.repositories.PersonRepositoty;
import com.example.easy_school_app.repositories.RoleRepository;

@Service
public class PersonService {
    @Autowired
    PersonRepositoty personRepositoty;

    @Autowired
    RoleRepository roleRepository;

    public boolean savePerson(Person person) {
        Roles role = roleRepository.findByRoleName(AppConstant.STUDENT_ROLE);
        person.setRole(role);
        Person newPerson = personRepositoty.save(person);
        return newPerson != null && newPerson.getPersonId() > 0;
    }
}
