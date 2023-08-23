package com.example.easy_school_app.models;

import lombok.Data;

@Data
public class Holiday {
    private final String day, reason;
    private final Type type;

    public enum Type {
        FESTIVAL,
        FEDERAL
    }

}
