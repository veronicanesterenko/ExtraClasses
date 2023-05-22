package org.example.extraclasses.enums;

public enum Subject {
    MATH("Math"),
    BIOLOGY("Biology"),
    PSYCHOLOGY("Psychology"),
    ENGLISH("English");

    private final String subjName;

    Subject(String subjName) {
        this.subjName = subjName;
    }

    public String getSubjName() {
        return subjName;
    }
}
