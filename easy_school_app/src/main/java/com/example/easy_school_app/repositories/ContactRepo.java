package com.example.easy_school_app.repositories;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.example.easy_school_app.models.Contact;
import com.example.easy_school_app.rowmappers.ContactRowMapper;

@Repository
public class ContactRepo {
    JdbcTemplate jdbcTemplate;

    public ContactRepo(JdbcTemplate jdbcTemplate) {
        System.out.println("COntact repo created@");
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertContact(Contact contact) {
        String insertSql = "insert into contact_msg (name,mobile_num,email,subject,message,status," +
                "created_at,created_by) values (?,?,?,?,?,?,?,?)";
        int result = this.jdbcTemplate.update(insertSql, contact.getName(), contact.getMobileNum(), contact.getEmail(),
                contact.getSubject(), contact.getMessage(), contact.getStatus(), contact.getCreatedAt(),
                contact.getCreatedBy());
        return result;
    }

    public List<Contact> getMessagesByStatus(String status) {
        String sql = "SELECT * FROM contact_msg WHERE status = ?";
        var results = this.jdbcTemplate.query(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, status);
            }
        }, new ContactRowMapper());
        // var result = this.jdbcTemplate.queryForObject(
        // "SELECT COUNT(*) FROM contact_msg", Integer.class);
        return results;
    }

    public int updateMessageStatus(int id, String updatedPerson, String newStatus) {

        String sql = "UPDATE contact_msg SET status = ?, updated_at = ?, updated_by = ? WHERE contact_id = ?";
        return this.jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, newStatus);
                ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                ps.setString(3, updatedPerson);
                ps.setInt(4, id);
            }
        });
    }
}
