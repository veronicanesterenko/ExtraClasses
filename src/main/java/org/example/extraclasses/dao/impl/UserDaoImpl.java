package org.example.extraclasses.dao.impl;

import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;
import org.example.extraclasses.exception.UserDaoException;
import org.example.extraclasses.exception.UserNotFoundException;
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
            String sql = "insert into `user`(`first_name`,`last_name`,`login`,`photo`,`role`)" +
                    "values (?,?,?,?,?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newUser.getFirstName());
            preparedStatement.setString(2, newUser.getLastName());
            preparedStatement.setString(3, newUser.getLogin());
            preparedStatement.setBlob(4, new ByteArrayInputStream(newUser.getPhoto()));
            preparedStatement.setString(5,newUser.getRole().toString());

            int count = preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return newUser;
    }

    @Override
    public List<User> getAllByRole(Role role) {
        List<User> teachers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String sql = "select id,first_name,last_name,login from `user` where `role`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,role.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                log.info("user_id: "+resultSet.getLong(1));
                user.setId(resultSet.getLong(1));

                log.info("first_name: "+resultSet.getString(2));
                user.setFirstName(resultSet.getString(2));

                log.info("last_name: "+resultSet.getString(3));
                user.setLastName(resultSet.getString(3));

                log.info("username: "+resultSet.getString(4));
                user.setLogin(resultSet.getString(4));

                teachers.add(user);

            }
        }  catch (SQLException throwables) {
            throw new UserDaoException("Cannot find all teachers ", throwables);
        }
        return teachers;
    }

    @Override
    public User findById(String id) {
        log.info("____Get user by id_____" +id);
        User user = new User();
        Connection connection = getConnection();
        String sql = "select id,first_name,last_name,login,photo,role from `user` where id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                throw new UserNotFoundException("User with id: " + id + " not found");
            }

            log.info("user_id: " + resultSet.getLong(1));
                user.setId(resultSet.getLong(1));

                log.info("first_name: " + resultSet.getString(2));
                user.setFirstName(resultSet.getString(2));

                log.info("last_name: " + resultSet.getString(3));
                user.setLastName(resultSet.getString(3));

                log.info("username: " + resultSet.getString(4));
                user.setLogin(resultSet.getString(4));

                user.setPhoto(resultSet.getBytes(5));

                String base64 = Base64.getEncoder().encodeToString(user.getPhoto());
                user.setPhotoBase64(base64);


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return user;
    }

    @Override
    public Integer getTeacherIdBySubjectId(long id) {
        Connection connection = getConnection();
       String sql = "select u.id " +
               "from user u join subjects_teachers st on u.id = st.teacher_id " +
               "where st.subject_id = ?";
       // String sql = "select  teacher_id from  subjects_teachers where subject_id = ?";
        Integer userId = null;
         try {
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setLong(1,id);
             ResultSet resultSet = preparedStatement.executeQuery();
             if (!resultSet.next()) {
                 throw new UserDaoException("There are not teacher on subject" + id);
             }
            userId =  resultSet.getInt(1);

             log.info("teacher_id" + userId );
         } catch (SQLException e) {
             e.printStackTrace();
         }
        return userId;
    }
}
