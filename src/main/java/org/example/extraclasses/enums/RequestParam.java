package org.example.extraclasses.enums;

public enum RequestParam {

    SUBJECT_NAME("subject_name"),
    ERROR_MESSAGE("error_message"),
    SUBJECTS("subjects"),
    SUBJECT("subject"),
    TEACHERS("teachers"),
    TEACHER("teacher"),
    STUDENTS("students"),
    STUDENT("student");

    private final String param;
    RequestParam(String param) {
        this.param = param;
    }

    public String val() {
        return param;
    }
}
