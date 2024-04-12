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

public class TeacherPage extends Action implements Loggable {
    Logger log = getLogger();
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FactoryException, TransactionException {
        logAction();

        UserDao userDao = getServiceFactory().getUserDao();


        String teacherId = request.getParameter("id");
        log.info("id: "+ request);
        User teacher = userDao.findById(teacherId);
        log.info("Teacher"+ teacher);
        request.setAttribute("teacher",teacher);

        return new Forward ("/teacher_page");
    }
}
