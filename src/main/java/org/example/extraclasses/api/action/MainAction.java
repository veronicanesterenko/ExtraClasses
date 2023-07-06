package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Action;
import org.example.extraclasses.api.ActionFactory;
import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.dao.impl.SubjectDaoImpl;
import org.example.extraclasses.entity.SubjectInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static org.example.extraclasses.enums.RequestParam.SUBJECTS;

public class MainAction extends Action {
    Logger log = Logger.getLogger(MainAction.class.getName());
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Start action : "+this.getClass().getName());
        SubjectDao subjectDao = new SubjectDaoImpl();
        List<SubjectInfo> subjects = subjectDao.findAll();
        request.setAttribute(SUBJECTS.val(),subjects);
        return new Forward("/main");
    }
}
