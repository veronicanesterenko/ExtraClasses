package org.example.extraclasses.dao;

import org.example.extraclasses.entity.SubjectInfo;

import java.util.List;

public interface SubjectDao {
    List<SubjectInfo> findAll();
}
