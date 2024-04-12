package org.example.extraclasses.service.user;

import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;

import java.util.List;

public interface UserService {
    User saveUser(User newUser);
    User findById(String id);
    List<User> getAllByRole(Role role);
}
