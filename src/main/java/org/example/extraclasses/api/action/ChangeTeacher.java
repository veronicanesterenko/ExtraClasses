package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;
import org.example.extraclasses.exception.CannotUpdateSubjectException;
import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.exception.TransactionException;
import org.example.extraclasses.service.transaction.Transaction;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static org.example.extraclasses.enums.RequestParam.*;

public class ChangeTeacher extends Action implements Loggable {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FactoryException, TransactionException {
        final Logger logger = getLogger();
        final String subjectId = request.getParameter("subject");
        final String teacherId = request.getParameter("teacher");
        final String subject_name = request.getParameter("subject_name");
        logger.info(" S U B J E C T ----" + subjectId);
        logger.info(" T e a c h e r ----" + teacherId);
        logger.info(" Subject - name ----" + subject_name);

        try{
        Transaction transaction = getServiceFactory().getTransaction();
        transaction.begin();

        SubjectDao subjectDao = getServiceFactory().getSubjectDao();
        subjectDao.updateTeacherForSubject(teacherId,subjectId);

            SubjectInfo subject = subjectDao.findByName(subject_name);
            UserDao userDao = getServiceFactory().getUserDao();
           // teacherId = userDao.getTeacherIdBySubjectId(subject.getId());
            logger.info("id: "+ request);
            User teacher = userDao.findById(String.valueOf(teacherId));
            logger.info("Teacher"+ teacher);

            List<User> listOfTeachers = userDao.getAllByRole(Role.TEACHER);


          /* SubjectService subjectService = getServiceFactory().getSubjectService();
            List<SubjectInfo> infoList = subjectService.getAll();
            request.setAttribute("subjects",infoList);*/

            request.setAttribute(SUBJECT_NAME.val(),subject);
            request.setAttribute(TEACHER.val(), teacher);
            request.setAttribute(TEACHERS.val(), listOfTeachers);

            return new Forward("/subject/subject");
        } catch (TransactionException e) {
            throw new CannotUpdateSubjectException(e);
        }


    }
}
