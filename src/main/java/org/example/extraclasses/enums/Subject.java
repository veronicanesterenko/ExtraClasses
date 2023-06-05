package org.example.extraclasses.enums;

public enum Subject {
    MATH("Math"),
    BIOLOGY("Biology"),
    PSYCHOLOGY("Psyhology"),
    ENGLISH("English");

    public String getSubjName() {
        return subjName;
    }

    private final String subjName;

    Subject(String subjName) {
        this.subjName = subjName;
    }


    public static Subject getByName(String name) {
        for (Subject subject : Subject.values()) {
            if (subject.subjName.equals(name)) {
                return subject;
            }
        }
        throw  new RuntimeException("no subject found with name: "+name);
    }
}
