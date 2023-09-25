package org.example.extraclasses.service.subject;

import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.service.transaction.EnableTransaction;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectServiceImpl extends EnableTransaction implements SubjectService {
    private final SubjectDao subjectDao;
    private final UserDao userDao;

    public List<SubjectInfo> getAll() {
        List<SubjectInfo> subjectInfos = subjectDao.findAll();
//        for (SubjectInfo subject : subjectInfos) {
//            int teacherId = userDao.getTeacherIdBySubject(subject.getId());
//            User teacher = userDao.findById(String.valueOf(teacherId));
//            subject.setTeacher(teacher);
//        }
//        return subjectInfos;
        return subjectInfos
                .stream()
                .map(subj -> {
                    int teacherId = userDao.getTeacherIdBySubject(subj.getId());
                    User teacher = userDao.findById(String.valueOf(teacherId));
                    subj.setTeacher(teacher);
                    return subj;
                }).collect(Collectors.toList());
    }

    public SubjectServiceImpl(SubjectDao subjectDao, UserDao userDao) {
        this.subjectDao = subjectDao;
        this.userDao = userDao;
    }

    @Override
    public SubjectInfo save(SubjectInfo subjectInfo) {
        return subjectDao.save(subjectInfo);
    }
}
