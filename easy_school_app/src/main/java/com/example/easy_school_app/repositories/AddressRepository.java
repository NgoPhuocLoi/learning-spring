package com.example.easy_school_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.easy_school_app.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
