package org.example.extraclasses.service.subject;

import org.example.extraclasses.api.action.Subject;
import org.example.extraclasses.entity.SubjectInfo;

import java.util.List;

public interface SubjectService {
    List<SubjectInfo> getAll();
    SubjectInfo save(SubjectInfo subjectInfo);
}
