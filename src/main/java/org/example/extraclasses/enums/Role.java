package org.example.extraclasses.enums;

import org.example.extraclasses.exception.ParseRequestException;

public enum Role {
    ADMIN,
    TEACHER,
    STUDENT;
    public static Role getByName(String name) {
        for (Role role : Role.values()) {
            if(role.name().equalsIgnoreCase(name)) {
                return role;
            }
        }
        throw new ParseRequestException("not found role by: " + name,null);
    }
}

