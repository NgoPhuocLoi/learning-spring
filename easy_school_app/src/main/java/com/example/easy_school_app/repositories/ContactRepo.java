package com.example.easy_school_app.repositories;

import java.sql.Timestamp;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.easy_school_app.models.Contact;

@Repository
public class ContactRepo {
    JdbcTemplate jdbcTemplate;

    public ContactRepo(JdbcTemplate jdbcTemplate) {
        System.out.println("COntact repo created@");
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertContact(Contact contact) {
        // String insertSql = "";
        var result = this.jdbcTemplate.update(
                "INSERT INTO `contact_msg` VALUES (1,dasd,dasd,dasd,asd,dasd,dasd, dasd, dasd,  null, null)");
        return result;
    }

    public int getRow() {
        var result = this.jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM contact_msg", Integer.class);
        return result;
    }
}
