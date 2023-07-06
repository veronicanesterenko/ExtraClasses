package org.example.extraclasses.enums;

public enum ForwardName {

    ERROR("error");
    private final String name;

    ForwardName(String name) {
        this.name = name;
    }

    public String val() {
        return name;
    }
}
