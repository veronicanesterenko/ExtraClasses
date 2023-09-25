package org.example.extraclasses.dao;

import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;

import java.util.List;

public interface UserDao {

    User save(User newUser);

    List<User> getAllByRole(Role role);

    User findById(String teacherId);

    Integer getTeacherIdBySubject(Long id);

}
