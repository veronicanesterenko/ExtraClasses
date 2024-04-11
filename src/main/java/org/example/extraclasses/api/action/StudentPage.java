package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.exception.TransactionException;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

import static org.example.extraclasses.enums.RequestParam.STUDENT;

public class StudentPage extends Action implements Loggable {

    Logger log = getLogger();
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FactoryException, TransactionException {


        UserDao userDao = getServiceFactory().getUserDao();


        String studentId = request.getParameter("id");
        log.info("id: "+ request);
        User student = userDao.findById(studentId);
        log.info("Student   ----   "+ student);
        request.setAttribute(STUDENT.val(),student);

        return new Forward ("/student_page");
    }
}
