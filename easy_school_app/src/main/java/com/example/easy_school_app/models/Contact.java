package com.example.easy_school_app.models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "contact_msg")
@NamedQueries({
        @NamedQuery(name = "Contact.findContactWithStatusCustomNamedQuery", query = "SELECT c FROM Contact c WHERE c.status = :status")
})
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "contact_id")
    private int contactId;
    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "ABC")
    @Column(name = "mobile_num")
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
    private String status;

}
