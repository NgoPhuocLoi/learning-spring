package com.example.easy_school_app.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Component
// @PropertySource
@ConfigurationProperties(prefix = "easy-school")
@Data
@Validated
public class EasySchoolProperties {
    @Min(value = 5, message = "Page size must be between 5 and 25")
    @Max(value = 25, message = "Page size must be between 5 and 25")
    private String defaultPageSize;
    private Map<String, String> contact;
    private List<String> branches;
}
