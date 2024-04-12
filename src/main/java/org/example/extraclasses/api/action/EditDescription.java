package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.exception.CannotUpdateSubjectException;
import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.exception.TransactionException;
import org.example.extraclasses.service.subject.SubjectService;
import org.example.extraclasses.service.transaction.Transaction;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class EditDescription extends Action implements Loggable {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FactoryException, TransactionException {
        final Logger log = getLogger();
        logAction();
        Transaction transaction = null;
        try {
            final String changedName = request.getParameter("changedName");
            log.info("changedName" + changedName);
            final String changedDesc = request.getParameter("changedDesc");
            log.info("changedDesc" + changedDesc);
            final String subjectId = request.getParameter("subject");
            log.info("subject" + subjectId);
            final String subjectName = request.getParameter("subject_name");
            log.info("subject_name" + subjectName);

            transaction = getServiceFactory().getTransaction();
            transaction.begin();

            final SubjectService subjectService = getServiceFactory().getSubjectService();
            subjectService.updateSubject(changedName, changedDesc, subjectId);
            log.info("id: " + subjectId);
            transaction.commit();

            //SubjectInfo subject = subjectService.findByName(changedName);
            /* SubjectService subjectService = getServiceFactory().getSubjectService();
            List<SubjectInfo> infoList = subjectService.getAll();
            request.setAttribute("subjects",infoList);*/
        } catch (TransactionException e) {
            transaction.rollback();
            throw new CannotUpdateSubjectException(new TransactionException("Update subject error ", e));
        }

        return new Forward("/main", true);
    }
}
