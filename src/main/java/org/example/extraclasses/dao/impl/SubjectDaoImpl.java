package org.example.extraclasses.dao.impl;

import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.enums.Subject;
import org.example.extraclasses.util.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.extraclasses.enums.Subject.*;

public class SubjectDaoImpl implements SubjectDao {
    Connection connection = null;
    List<SubjectInfo> subjectInfos = new ArrayList<>();
    @Override
    public List<SubjectInfo> findAll() {
        try {

            connection= Connector.getConnection();
            String sql ="select `subject_id`, `name`,`description`,`hours`,`free` from subject";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            int offset = 0;
            while (resultSet.next()) {
                offset++;
                String name = resultSet.getString(2);
                int hours = resultSet.getInt("hours");
                String descrition = resultSet.getString(3);
                boolean isFree = resultSet.getBoolean(5);
                SubjectInfo info = new SubjectInfo(
                        Subject.getByName(name),
                        hours,
                        descrition,
                        isFree
                );
                subjectInfos.add(info);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return subjectInfos;
    }
}
