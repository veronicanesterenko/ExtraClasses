package org.example.extraclasses.enums;

public enum SubjectName {
    MATH("Math"),
    BIOLOGY("Biology"),
    PSYCHOLOGY("Psychology"),
    ENGLISH("English");

    private final String subjName;

    SubjectName(String subjName) {
        this.subjName = subjName;
    }
    public static SubjectName getByName(String name){
        for (SubjectName subjectName : SubjectName.values()){
            if(subjectName.subjName.equals(name)) {
                return subjectName;
            }
        }
        throw new RuntimeException("no subject found with name: "+ name);
    }

    public String getSubjName() {
        return subjName;
    }
}
