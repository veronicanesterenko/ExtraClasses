package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;
import org.example.extraclasses.exceptions.FactoryException;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class ServiceTeachers extends Action implements Loggable {

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FactoryException {
        UserDao userDao = getServiceFactory().getUserDao();
        Logger log = getLogger();

        List<User> teachers = userDao.getAllByRole(Role.TEACHER);

        log.info("\n\n\nfound teachers\n\n\n\r");
        teachers.forEach(teacher -> log.info(teacher.toString()));
        log.info("\n\n\n end teachers\n\n\n\r");
        request.setAttribute("teachers", teachers);
        return new Forward("/teachers");
    }
}
