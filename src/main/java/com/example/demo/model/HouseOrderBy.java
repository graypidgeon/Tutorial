package com.example.demo.model;

public enum HouseOrderBy {
    DESCRIPTION("Description"), NAME("Name"), USAGE_AREA("Usage area", "usageArea");

    private final String value;
    private final String propertyName;
    HouseOrderBy(String value) {
        this.value = value;
        propertyName = name().toLowerCase();
    }
    HouseOrderBy(String value, String propertyName) {
        this.value = value;
        this.propertyName = propertyName;
    }

    public String getValue() {
        return value;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
