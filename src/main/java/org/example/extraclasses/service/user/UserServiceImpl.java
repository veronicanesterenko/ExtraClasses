package org.example.extraclasses.service.user;

import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.dao.impl.UserDaoImpl;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.service.transaction.EnableTransaction;

public class UserServiceImpl extends EnableTransaction implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User saveUser(User newUser){

        return userDao.save(newUser);
    }
}
