package org.example.extraclasses.dao.impl;

import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.exception.SubjectDaoException;
import org.example.extraclasses.exception.UserDaoException;
import org.example.extraclasses.util.EnableConnection;
import org.example.extraclasses.util.Loggable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SubjectDaoImpl extends EnableConnection implements SubjectDao, Loggable {
    Logger log = getLogger();
    String allFields = "`subject_id`, `name`,`description`,`hours`,`free`";
    User user;

    List<SubjectInfo> subjectInfos = new ArrayList<>();

    @Override
    public List<SubjectInfo> findAll() {
        try {
            Connection connection = getConnection();
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
                        isFree, null, null);
                info.setId(id);
                subjectInfos.add(info);
            }
        } catch (Exception throwable) {
            throw new SubjectDaoException("Error during find all subjects: ", throwable);
        }
        return subjectInfos;
    }

    private SubjectInfo extractSubject(ResultSet resultSet) throws SQLException {
        SubjectInfo info = null;
        while (resultSet.next()) {

            long id = resultSet.getInt(1);
            log.info("I D :" + id);
            String name = resultSet.getString(2);
            int hours = resultSet.getInt("hours");
            String description = resultSet.getString(3);
            boolean isFree = resultSet.getBoolean(5);

            info = new SubjectInfo(
                    name,
                    hours,
                    description,
                    isFree, null
                    , null);
            info.setId(id);
        }
        return info;
    }

    @Override
    public SubjectInfo findByName(String name) {
        SubjectInfo info = null;
        String sql = null;
        try {
            Connection connection = getConnection();
            sql = "select " + allFields + " from subject where name =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            info = extractSubject(resultSet);

        } catch (SQLException throwable) {
            log.severe("Error during find subject by: " + sql + name);
            throwable.printStackTrace();
        }
        return info;
    }

    public SubjectInfo saveSubject(SubjectInfo newSubject) {
        log.info("start saving subject: " + newSubject);
        try {
            Connection connection = getConnection();
            String sql = "insert into `subject`(`name`,`description`,`hours`,`free`)" +
                    "values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newSubject.getName());
            preparedStatement.setString(2, newSubject.getDescription());
            preparedStatement.setInt(3, newSubject.getHoursCount());
            preparedStatement.setBoolean(4, newSubject.isFree());

            int count = preparedStatement.executeUpdate();
            log.info(count+"rows affected");
            try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    final long generated =generatedKeys.getLong(1);
                    log.info("generated"+generated);
                    newSubject.setId(generated);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return newSubject;
    }

    @Override
    public SubjectInfo saveTeacherForSubject(SubjectInfo subjectInfo) {
        log.info("start saving teacher" + subjectInfo.getTeacher().getId());
        try {
            Connection connection = getConnection();
            String sql = "insert into `subjects_teachers`(subject_id,teacher_id)" +
                    "values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, subjectInfo.getId());
            preparedStatement.setLong(2, subjectInfo.getTeacher().getId());


            int count = preparedStatement.executeUpdate();
            log.info(count+"rows affected");


        } catch (SQLException throwables) {
           throw  new UserDaoException("error during save teacher for subject", throwables);
        }
        return subjectInfo;
    }

    public SubjectInfo saveStudentForSubject(SubjectInfo subjectInfo, User student) {
      //  log.info("start saving student for subject" + subjectInfo.getTeacher().getId());
        try {

            Connection connection = getConnection();
            String sql = "insert into `subjects_students`(subject_id,student_id)" +
                    "values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, subjectInfo.getId());
            preparedStatement.setLong(2, student.getId());


            int count = preparedStatement.executeUpdate();
            log.info(count+"rows affected");


        } catch (SQLException throwables) {
            throw  new UserDaoException("error during save student for subject", throwables);
        }
        return subjectInfo;
    }

    @Override
    public void updateTeacherForSubject(String teacherId, String subjectId) {
        log.info("start update teacher for subject. teacherId: " + teacherId + "subjectId: "+subjectId);
        try {
            Connection connection = getConnection();
            String sql = "update `subjects_teachers`set teacher_id=? where subject_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, Long.parseLong(teacherId));
            preparedStatement.setLong(2, Long.parseLong(subjectId));


            int count = preparedStatement.executeUpdate();
            log.info(count+"rows affected");


        } catch (SQLException throwables) {
            throw  new UserDaoException("error during save teacher for subject", throwables);
        }
            }

    @Override
    public void updateSubject(String changedName, String changedDesc, String subjectId) {
        try {
            Connection connection = getConnection();
            String sql = "update `subject`set name=?, description=? where subject_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, changedName);
            preparedStatement.setString(2, changedDesc);
            preparedStatement.setLong(3, Long.parseLong(subjectId));

            int count = preparedStatement.executeUpdate();
            log.info(count +" rows affected");
        } catch (SQLException throwables) {
            throw  new SubjectDaoException("error during update subject's name or description", throwables);
        }
    }
}
