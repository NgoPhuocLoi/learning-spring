package com.example.easy_school_app.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Holiday extends BaseEntity {
    private String day, reason;
    private Type type;

    public enum Type {
        FESTIVAL,
        FEDERAL
    }

}
