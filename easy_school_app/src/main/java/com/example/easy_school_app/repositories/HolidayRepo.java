package com.example.easy_school_app.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.easy_school_app.models.Holiday;

import java.util.List;

@Repository
public class HolidayRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Holiday> getAllHolidays() {
        String sql = "SELECT * FROM holidays";
        RowMapper<Holiday> holidayRowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
        var results = jdbcTemplate.query(sql, holidayRowMapper);
        return results;
    }
}
