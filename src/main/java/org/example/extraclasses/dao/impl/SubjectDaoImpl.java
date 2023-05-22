package org.example.extraclasses.dao.impl;

import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.enums.Subject;

import java.util.Arrays;
import java.util.List;

import static org.example.extraclasses.enums.Subject.*;

public class SubjectDaoImpl implements SubjectDao {
    @Override
    public List<SubjectInfo> findAll() {
        return Arrays.asList(
                new SubjectInfo(BIOLOGY, 50, "Lerning about all live organisms", false),
                new SubjectInfo(MATH, 150, "Lerning formulas and digits", true),
                new SubjectInfo(ENGLISH, 450, "Lerning reading and speaking english", true),
                new SubjectInfo(PSYCHOLOGY, 120, "Lerning about human inner life", true)
        );
    }
}
