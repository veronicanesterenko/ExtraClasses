package org.example.extraclasses.dao;

import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.entity.User;

import java.util.List;

public interface SubjectDao {
    List<SubjectInfo> findAll();
    SubjectInfo findByName(String name);
    SubjectInfo saveSubject (SubjectInfo newSubject);
    SubjectInfo saveTeacherForSubject(SubjectInfo subjectInfo);
    void updateTeacherForSubject(String teacherId, String subjectId);

    void updateSubject(String changedName, String changedDesc, String subjectId);
    SubjectInfo saveStudentForSubject(SubjectInfo subjectInfo, User student);
}
