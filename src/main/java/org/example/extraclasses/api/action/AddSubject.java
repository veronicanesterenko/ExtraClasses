package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.exception.TransactionException;
import org.example.extraclasses.service.subject.SubjectService;
import org.example.extraclasses.service.transaction.Transaction;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import static org.example.extraclasses.enums.RequestParam.ERROR_MESSAGE;

public class AddSubject extends Action implements Loggable {

    private final Logger log = getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FactoryException, TransactionException {
        Transaction transaction = getServiceFactory().getTransaction();
        try {
            transaction.begin();
            SubjectService subjectService = getServiceFactory().getSubjectService();

            log.info("Start action: " + Action.class.getName());

            String name = request.getParameter("subjectName");
            log.info("subjectName: " + name);


            String description = request.getParameter("subjectDescription");
            log.info("subjectDescription: " + description);

            Integer hoursCount = Integer.parseInt(request.getParameter("hoursCount"));
            log.info("hoursCount is: " + hoursCount);

            boolean isFree = Boolean.parseBoolean(request.getParameter("isFree"));
            log.info("isFree: " + isFree);
            String teacher_id = request.getParameter("teacher");
            log.info("///Teacher_id" + teacher_id);
            User teacher = new User();
            teacher.setId(Long.parseLong(teacher_id));

            SubjectInfo subjectInfo = new SubjectInfo(name, hoursCount, description, isFree, teacher, null);
            subjectService.saveSubject(subjectInfo);
            transaction.commit();

            return new Forward("/subject/subjects",true);
        } catch (TransactionException e) {
            String msg = String.format("ERROR during add subject: %s, %s", e.getMessage(), Arrays.toString(e.getStackTrace()));
            log.severe(msg);
            transaction.rollback();
            request.setAttribute(ERROR_MESSAGE.val(), msg);
            return new Forward("/error");

        }
    }
}