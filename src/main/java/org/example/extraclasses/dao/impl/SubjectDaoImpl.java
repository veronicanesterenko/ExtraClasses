package org.example.extraclasses.dao.impl;

import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.enums.SubjectName;
import org.example.extraclasses.util.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SubjectDaoImpl implements SubjectDao {
    Logger log = Logger.getLogger(SubjectInfo.class.getName());
    String allFields = "`subject_id`, `name`,`description`,`hours`,`free`";
    Connection connection = null;
    List<SubjectInfo> subjectInfos = new ArrayList<>();

    @Override
    public List<SubjectInfo> findAll() {

        try {

            connection = Connector.getConnection();
            String sql = "select " + allFields + " from subject";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                String name = resultSet.getString(2);
                int hours = resultSet.getInt("hours");
                String description = resultSet.getString(3);
                boolean isFree = resultSet.getBoolean(5);
                SubjectInfo info = new SubjectInfo(
                        SubjectName.getByName(name),
                        hours,
                        description,
                        isFree
                );
                subjectInfos.add(info);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return subjectInfos;
    }

    private SubjectInfo extractSubject (ResultSet resultSet) throws SQLException {
        SubjectInfo info = null;
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            int hours = resultSet.getInt("hours");
            String description = resultSet.getString(3);
            boolean isFree = resultSet.getBoolean(5);
            return  new SubjectInfo(
                    SubjectName.getByName(name),
                    hours,
                    description,
                    isFree
            );
        }
        return info;
    }
     @Override
    public SubjectInfo findByName(String name) {
        Connection connection = null;
        SubjectInfo info = null;
        String sql = null;
        try {
            connection = Connector.getConnection();
            sql = "select " + allFields + " from subject where name =?";
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
}
