package org.example.extraclasses.dao;

import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;

import java.util.List;

public interface UserDao {

    User save(User newUser);

    List<User> getAllByRole(Role role);

    User findById(String id);
    Integer getTeacherIdBySubjectId(long id);

    List<User> getStudentListBySubjectId(long id);
}
