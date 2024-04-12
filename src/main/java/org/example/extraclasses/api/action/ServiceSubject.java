package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;
import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.exception.TransactionException;
import org.example.extraclasses.service.subject.SubjectService;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class ServiceSubject extends Action implements Loggable {
    private final static Logger log = Logger.getLogger(ServiceSubject.class.getName());
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FactoryException, TransactionException {
        logAction();
        SubjectService subjectService = getServiceFactory().getSubjectService();
        List<SubjectInfo> infoList = subjectService.getAll();
        UserDao userDao = getServiceFactory().getUserDao();

        List<User> teachersList = userDao.getAllByRole(Role.TEACHER);

        log.info("Found:" + infoList.size() + "subjects");

        request.setAttribute("subjects",infoList);
        request.setAttribute("teachers",teachersList);

        return new Forward("/subject/subjects");
    }
}
