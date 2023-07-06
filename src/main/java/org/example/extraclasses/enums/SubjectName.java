package org.example.extraclasses.enums;

import java.util.HashSet;

public enum SubjectName {
    MATH("Math"),
    BIOLOGY("Biology"),
    PSYCHOLOGY("Psychology"),
    ENGLISH("English");

    public String getSubjName() {
        return subjName;
    }

    private final String subjName;

    SubjectName(String subjName) {
        this.subjName = subjName;
    }


    public static SubjectName getByName(String name) {
        for (SubjectName subjectName : SubjectName.values()) {
            if (subjectName.subjName.equals(name)) {
                return subjectName;
            }
        }
        throw  new RuntimeException("no subject found with name: "+name);
    }

}
