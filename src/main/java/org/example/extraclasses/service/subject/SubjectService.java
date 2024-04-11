package org.example.extraclasses.service.subject;

import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.entity.User;

import java.util.List;

public interface SubjectService {
    List<SubjectInfo> getAll();
    SubjectInfo saveSubject(SubjectInfo newSubject);
    void updateSubject(String changedName, String changedDesc, String subjectId);
    SubjectInfo findByName(String name);
    SubjectInfo saveStudentForSubject(SubjectInfo subjectInfo, User student);
}
