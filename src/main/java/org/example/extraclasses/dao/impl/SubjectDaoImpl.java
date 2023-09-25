package org.example.extraclasses.dao.impl;

import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.exceptions.SubjectDaoException;
import org.example.extraclasses.exceptions.UserDaoException;
import org.example.extraclasses.util.EnableConnection;
import org.example.extraclasses.util.Loggable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SubjectDaoImpl extends EnableConnection implements SubjectDao, Loggable {
    Logger log = getLogger();
    private static final String allFields = "`subject_id`, `name`, `description`, `hours`, `free`";


    @Override
    public List<SubjectInfo> findAll() {
        List<SubjectInfo> subjectInfos = new ArrayList<>();
        Connection connection = getConnection();
        log.info("connection: " + connection);
        try {
            String sql = "select " + allFields + " from subject";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = (long) resultSet.getInt(1);
                String name = resultSet.getString(2);
                int hours = resultSet.getInt("hours");
                String description = resultSet.getString(3);
                boolean isFree = resultSet.getBoolean(5);
                SubjectInfo info = new SubjectInfo(
                        name,
                        hours,
                        description,
                        isFree,
                        null, null);
                info.setId(id);
                subjectInfos.add(info);
            }
        } catch (Exception throwables) {
            throw new SubjectDaoException("Error during find all subjects: ", throwables);
        }
        return subjectInfos;
    }

    private SubjectInfo extractSubject(ResultSet resultSet) throws SQLException {
        SubjectInfo info = null;
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            int hours = resultSet.getInt("hours");
            String description = resultSet.getString(3);
            boolean isFree = resultSet.getBoolean(5);
            info = new SubjectInfo(
                    name,
                    hours,
                    description,
                    isFree,
                    null, null);
        }
        return info;
    }

    @Override
    public SubjectInfo findByName(String name) {
        SubjectInfo info = null;
        String sql = null;
        try {
            Connection connection = getConnection();
            sql = "select " + allFields + " from subject where name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            info = extractSubject(resultSet);
        } catch (SQLException throwables) {
            log.severe("Error during find subject by: " + sql + name);
            throwables.printStackTrace();
        }
        return info;
    }

    @Override
    public SubjectInfo save(SubjectInfo subjectInfo) {
        log.info("start saving subject: " + subjectInfo);

        try {
            Connection connection = getConnection();

            String sql = "insert into `subject` (name, description, hours, free)" +
                    " values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, subjectInfo.getName());
            preparedStatement.setString(2, subjectInfo.getDescription());
            preparedStatement.setInt(3, subjectInfo.getHoursCount());
            preparedStatement.setBoolean(4, subjectInfo.isFree());
            int i = preparedStatement.executeUpdate();
            log.info(i + " rows affected");
        } catch (SQLException throwables) {
            throw new UserDaoException("Error during save new user", throwables);
        }
        return null;
    }
}
