package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.exceptions.FactoryException;
import org.example.extraclasses.exceptions.TransactionException;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class ServiceSubject extends Action implements Loggable {
    Logger log = getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FactoryException, TransactionException {
        logAction();
        SubjectDao subjectDao = getServiceFactory().getSubjectDao();
        List<SubjectInfo> infoList = subjectDao.findAll();
        log.info("Found: " + infoList.size() + " subjects");
        request.setAttribute("subjects", infoList);
        return new Forward("/subject/subjects");


    }
}
