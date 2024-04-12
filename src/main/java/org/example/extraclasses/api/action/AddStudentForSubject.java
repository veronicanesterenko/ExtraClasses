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
import org.example.extraclasses.service.subject.SubjectService;
import org.example.extraclasses.service.transaction.Transaction;
import org.example.extraclasses.service.user.UserService;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static org.example.extraclasses.enums.RequestParam.*;

public class AddStudentForSubject extends Action implements Loggable {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FactoryException, TransactionException {
        final Logger logger = getLogger();
        final String subjectId = request.getParameter("subject");
        final String studentId = request.getParameter("student");
        final String subject_name = request.getParameter("subject_name");
        final String teacherId = request.getParameter("teacher");
        logger.info(" S U B J E C T ----" + subjectId);
        logger.info(" S t u d e n t ----" + studentId);
        logger.info(" Subject - name ----" + subject_name);

        try{
            Transaction transaction = getServiceFactory().getTransaction();
            transaction.begin();

            SubjectService subjectService = getServiceFactory().getSubjectService();
            SubjectInfo subjectInfo = subjectService.findByName(subject_name);
            UserService userService = getServiceFactory().getUserService();
            List<User> listOfStudents = userService.getAllByRole(Role.STUDENT);
            User student = userService.findById(String.valueOf(studentId));
            logger.info("Student-------------"+ student);
            subjectService.saveStudentForSubject(subjectInfo, student);
            logger.info("--------------id: "+ request);
           User teacher = userService.findById(String.valueOf(teacherId));
            logger.info("Teacher"+ teacher);

            /*  List<User> listOfTeachers = userService.getAllByRole(Role.TEACHER);*/
            transaction.commit();





            request.setAttribute(SUBJECT_NAME.val(),subjectInfo);
            request.setAttribute(STUDENT.val(), student);
            request.setAttribute(STUDENTS.val(), listOfStudents);
            request.setAttribute(TEACHER.val(), teacher);

            return new Forward("/subject/subject");
        } catch (TransactionException e) {
            throw new CannotUpdateSubjectException(e);
        }


    }
}

