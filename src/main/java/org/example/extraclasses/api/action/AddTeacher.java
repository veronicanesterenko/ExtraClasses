package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;
import org.example.extraclasses.exceptions.FactoryException;
import org.example.extraclasses.exceptions.TransactionException;
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

            log.info("Start action: " + this.getClass().getName());

            //first name
            String firstName = request.getParameter("teacherFirstName");
            log.info("teacher first name: " + firstName);

            //last name
            String lastName = request.getParameter("teacherLastName");
            log.info("teacher last name: " + lastName);

            //teacherLogin
            String teacherLogin = request.getParameter("teacherLogin");
            log.info("teacherLogin: " + teacherLogin);

            //teacher Password
            String teacherPassword = request.getParameter("teacherPassword");
            log.info("teacherPassword: " + teacherPassword);

            //photo
            byte[] photo = RequestUtil.readBytesByParamName(request, "teacherPhoto", 20_000);

            User teacher = new User(firstName, lastName, teacherLogin, photo, Role.TEACHER);
            userService.saveUser(teacher);
            transaction.commit();
            return new Forward("/service/teachers", true);

        } catch (TransactionException e) {
            String msg = String.format("ERROR during add teacher: %s, %s",
                    e.getMessage(),
                    Arrays.toString(e.getStackTrace()));

            log.severe(msg);
            transaction.rollback();
            request.setAttribute(ERROR_MESSAGE.val(), msg);
            return new Forward("/error");
        }
    }
}
