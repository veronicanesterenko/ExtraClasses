package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Action;
import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.dao.impl.SubjectDaoImpl;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.enums.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

import static org.example.extraclasses.enums.RequestParam.*;

public class Subject extends Action {

    Logger log = Logger.getLogger(Subject.class.getName());
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Start action: "+Action.class.getName());

        String subject_name = request.getParameter("subject_name");

        SubjectDao subjectDao = new SubjectDaoImpl();
        SubjectInfo subject = subjectDao.findByName(subject_name);

        if(subject==null) {
            request.setAttribute(ERROR_MESSAGE.val(), "Subject not found by name: "+subject_name);
            return new Forward("/error");
        }

        request.setAttribute(SUBJECT.val(),subject);
        return new Forward("subject/subject");

    }
}
