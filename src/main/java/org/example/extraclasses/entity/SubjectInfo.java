package org.example.extraclasses.entity;

import java.util.List;

public class SubjectInfo {
    private long id;
    private String name;
    private int hoursCount;
    private String description;
    private boolean isFree;
    private User teacher;

    public void setStudents(List<String> students) {
        this.students = students;
    }

    private List<String> students;

    public User getTeacher() {
        return teacher;
    }

    public List<String> getStudents() {
        return students;
    }

    public SubjectInfo(String name, int hoursCount, String description, boolean isFree, User teacher, List<String> students) {
        this.name = name;
        this.hoursCount = hoursCount;
        this.description = description;
        this.isFree = isFree;
        this.teacher = teacher;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SubjectInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hoursCount=" + hoursCount +
                ", description='" + description + '\'' +
                ", isFree=" + isFree +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
