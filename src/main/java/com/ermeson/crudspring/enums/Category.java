package com.ermeson.crudspring.enums;

public enum Category {
    BACKEND("Back-end"), FRONTEND("Front-end"), FULLSTACK("Full-stack");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
