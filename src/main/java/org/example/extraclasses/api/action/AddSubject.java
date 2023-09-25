package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.exceptions.FactoryException;
import org.example.extraclasses.exceptions.TransactionException;
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
    Logger log = getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FactoryException, TransactionException {
        Transaction transaction = getServiceFactory().getTransaction();
        logAction();
        SubjectService subjectService = getServiceFactory().getSubjectService();

        try {
            transaction.begin();

            //name
            String subjectName = request.getParameter("subjectName");
            log.info("subjectName: " + subjectName);

            //description
            String subjectDescription = request.getParameter("subjectDescription");
            log.info("subjectDescription: " + subjectDescription);

            //hours
            Integer hoursCount = Integer.parseInt(request.getParameter("hoursCount"));
            log.info("hoursCount: " + hoursCount);


            //is free
            boolean isFree = Boolean.parseBoolean(request.getParameter("isFree"));
            log.info("isFree: " + isFree);

            SubjectInfo subjectInfo = new SubjectInfo(
                    subjectName, hoursCount, subjectDescription, isFree,
                    null, null);
            subjectService.save(subjectInfo);
            transaction.commit();
            return new Forward("/service/subjects", true);

        } catch (TransactionException e) {
            String msg = String.format("ERROR during add subject: %s, %s",
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));

            log.severe(msg);
            transaction.rollback();
            request.setAttribute(ERROR_MESSAGE.val(), msg);
            return new Forward("/error");
        }
    }
}
