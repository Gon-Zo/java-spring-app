package com.app.api.enums;

/**
 * Roles Enum
 */
public enum Roles {

    M("MANAGER"),
    A("ADMIN"),
    U("USER");

    private String value;

    Roles(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
