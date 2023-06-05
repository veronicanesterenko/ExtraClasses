package org.example.extraclasses.service.subject;


import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.entity.SubjectInfo;

import java.util.List;

public class SubjectService {
    private final SubjectDao subjectDao;

    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public List<SubjectInfo> getAll() {
        return subjectDao.findAll();
    }
}
