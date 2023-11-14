package org.example.extraclasses.service.subject;


import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.service.transaction.EnableTransaction;
import org.example.extraclasses.util.Loggable;

import java.util.List;
import java.util.logging.Logger;

public class SubjectServiceImpl extends EnableTransaction implements SubjectService, Loggable {
    Logger log = getLogger();
    private final SubjectDao subjectDao;
    private final UserDao userDao;

    public SubjectServiceImpl(SubjectDao subjectDao,UserDao userDao) {
        this.subjectDao = subjectDao;
        this.userDao = userDao;
    }

    @Override
    public List<SubjectInfo> getAll() {
        List<SubjectInfo> subjectInfos = subjectDao.findAll();
        log.info("Subject Infos" + subjectInfos);
        for (SubjectInfo subject: subjectInfos) {
            int teacherId = userDao.getTeacherIdBySubjectId(subject.getId());
            User teacher = userDao.findById(String.valueOf(teacherId));
            subject.setTeacher(teacher);
        }
        return subjectInfos;
    }

    @Override
    public SubjectInfo saveSubject(SubjectInfo newSubject) {
        SubjectInfo saved = subjectDao.saveSubject(newSubject);
        return subjectDao.saveTeacherForSubject(saved);
    }

    @Override
    public void updateSubject(String changedName, String changedDesc, String subjectId) {
        subjectDao.updateSubject(changedName, changedDesc, subjectId);
    }

    @Override
    public SubjectInfo findByName(String name) {
        return subjectDao.findByName(name);
    }
}
