package com.example.demo.model;

public enum Garage {
    NO ("No garage"), ONE ("One place"), TWO ("Two places");
    private String value;

    private Garage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
