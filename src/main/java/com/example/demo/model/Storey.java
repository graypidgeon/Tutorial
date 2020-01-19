package com.example.demo.model;

public enum Storey {
    GROUND_FLOOR ("Ground floor"), ATTIC ("With attic"), STOREY_HOUSE ("Storey house");

    private String value;

    private Storey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
