package com.example.demo.model;

public enum HouseOrderBy {
    DESCRIPTION("Description"), NAME("Name");

    private final String value;
    HouseOrderBy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getPropertyName() {
        return name().toLowerCase();
    }
}
