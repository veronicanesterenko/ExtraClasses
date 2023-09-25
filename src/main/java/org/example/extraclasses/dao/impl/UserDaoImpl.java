package org.example.extraclasses.dao.impl;

import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;
import org.example.extraclasses.exceptions.UserDaoException;
import org.example.extraclasses.exceptions.UserNotFoundException;
import org.example.extraclasses.util.EnableConnection;
import org.example.extraclasses.util.Loggable;

import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

public class UserDaoImpl extends EnableConnection implements UserDao, Loggable {
    private final Logger log = getLogger();


    @Override
    public User save(User newUser) {
        log.info("start saving user: " + newUser);

        try {
            Connection connection = getConnection();

            String sql = "insert into `user` (`first_name`, `last_name`, `login`, `photo`, `role`)" +
                    " values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newUser.getFirstName());
            preparedStatement.setString(2, newUser.getLastName());
            preparedStatement.setString(3, newUser.getLogin());
            preparedStatement.setBlob(4, new ByteArrayInputStream(newUser.getPhoto()));
            preparedStatement.setString(5, newUser.getRole().toString());
            int i = preparedStatement.executeUpdate();
            log.info(i + " rows affected");
        } catch (SQLException throwables) {
            throw new UserDaoException("Error during save new user", throwables);
        }
        return null;
    }

    @Override
    public List<User> getAllByRole(Role role) {
        List<User> teachers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String sql = "select `id`,`first_name`, `last_name`, `login`  from `user` where `role` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role.toString());
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                User user = new User();
                log.info("user_id: " + resultSet.getLong(1));
                user.setId(resultSet.getLong(1));

                log.info("first_name: " + resultSet.getString(2));
                user.setFirstName(resultSet.getString(2));

                log.info("last_name: " + resultSet.getString(3));
                user.setLastName(resultSet.getString(3));

                log.info("login: " + resultSet.getString(4));
                user.setLogin(resultSet.getString(4));
                teachers.add(user);
            }
        } catch (SQLException throwables) {
            throw new UserDaoException("Cannot find all teachers", throwables);
        }
        return teachers;
    }

    @Override
    public User findById(String teacherId) {
        Connection connection = getConnection();
        String sql = "select id, first_name, last_name, login, photo, role from user where id =?";
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(teacherId));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                throw new UserNotFoundException("User with id : " + teacherId + " not found");
            }

            log.info("user_id: " + resultSet.getLong(1));
            user.setId(resultSet.getLong(1));

            log.info("first_name: " + resultSet.getString(2));
            user.setFirstName(resultSet.getString(2));

            log.info("last_name: " + resultSet.getString(3));
            user.setLastName(resultSet.getString(3));

            log.info("login: " + resultSet.getString(4));
            user.setLogin(resultSet.getString(4));

            user.setPhoto(resultSet.getBytes(5));

            String photoBase64 = Base64.getEncoder().encodeToString(user.getPhoto());
            user.setPhotoBase64(photoBase64);
            log.info("base64: " + user.getPhotoBase64());

            log.info("Role: " + resultSet.getString(6));
            user.setRole(Role.valueOf(resultSet.getString(6)));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public Integer getTeacherIdBySubject(Long id) {
        Connection connection = getConnection();
        String sql = "select u.id " +
                " from user u " +
                " join subjects_teacher ts on u.id = ts.teacher_id" +
                " where ts.subject_id = ?";
        Integer userId = null;
        try {
            log.info("find user with sql: " + sql);
            log.info("id: " + id);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                throw new UserDaoException("There are not teachers on subject: " + id);
            }
            userId = resultSet.getInt(1);
            log.info("teacher id: " + userId);
            return userId;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userId;
    }
}
