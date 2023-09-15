package com.example.comsuming_rest.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data

public class BaseEntity {
    @JsonIgnore
    private LocalDateTime createdAt;
    @JsonIgnore
    private String createdBy;
    @JsonIgnore
    private LocalDateTime updatedAt;
    @JsonIgnore
    private String updatedBy;
}
