package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;
import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.exception.TransactionException;
import org.example.extraclasses.service.transaction.Transaction;
import org.example.extraclasses.service.user.UserService;
import org.example.extraclasses.util.Loggable;
import org.example.extraclasses.util.RequestUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.logging.Logger;

import static org.example.extraclasses.enums.RequestParam.ERROR_MESSAGE;

public class AddTeacher extends Action implements Loggable {
    private final Logger log = getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws FactoryException, TransactionException {
            Transaction transaction = getServiceFactory().getTransaction();
            try {
            transaction.begin();
            UserService userService = getServiceFactory().getUserService();

            log.info("Start action: " + Action.class.getName());

            String firstName = request.getParameter("teacherFirstName");
            log.info("teacher FirstName: " + firstName);

            String lastName = request.getParameter("teacherLastName");
            log.info("teacher LastName: " + lastName);

            String teacherUsername = request.getParameter("teacherUsername");
            log.info("teacher Username: " + teacherUsername);

            String teacherPassword = request.getParameter("teacherPassword");
            log.info("teacher Password: " + teacherPassword);

            byte[] photo = RequestUtil.readBytesByParamName(request, "teacherPhoto", 2000000);
            log.info("photoSize " + photo);

            User teacher = new User(firstName, lastName, teacherUsername, photo, Role.TEACHER);
            userService.saveUser(teacher);
            transaction.commit();

            return new Forward("/service/teachers", true);
        } catch (TransactionException e) {
            String msg  =String.format("ERROR during add teacher: %s, %s",e.getMessage(), Arrays.toString(e.getStackTrace()));
            log.severe(msg);
            transaction.rollback();
            request.setAttribute(ERROR_MESSAGE.val(),msg);
            return new Forward("/error");
        }
    }
}

