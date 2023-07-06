package org.example.extraclasses.entity;

import org.example.extraclasses.enums.SubjectName;

public class SubjectInfo {
    private long id;
    private SubjectName name;
    private int hoursCount;
    private String description;
    private boolean isFree;

    public SubjectInfo(SubjectName name, int hoursCount, String description, boolean isFree) {
        this.name = name;
        this.hoursCount = hoursCount;
        this.description = description;
        this.isFree = isFree;
    }

    public SubjectName getName() {
        return name;
    }

    public void setName(SubjectName name) {
        this.name = name;
    }

    public int getHoursCount() {
        return hoursCount;
    }

    public void setHoursCount(int hoursCount) {
        this.hoursCount = hoursCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
