package com.example.easy_school_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.easy_school_app.constants.AppConstant;
import com.example.easy_school_app.models.Person;
import com.example.easy_school_app.models.Roles;
import com.example.easy_school_app.repositories.PersonRepository;
import com.example.easy_school_app.repositories.RoleRepository;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean savePerson(Person person) {
        Roles role = roleRepository.findByRoleName(AppConstant.STUDENT_ROLE);
        person.setRole(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        Person newPerson = personRepository.save(person);
        return newPerson != null && newPerson.getPersonId() > 0;
    }
}
