package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class ServiceTeachers extends Action implements Loggable {
    private final static Logger log = Logger.getLogger(ServiceTeachers.class.getName());


    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDao userDao = getServiceFactory().getUserDao();
         List<User> teachers = userDao.getAllByRole(Role.TEACHER);
         request.setAttribute("teachers",teachers);
         log.info("\n\n\nfound teachers\n\n\n\n\n");
         teachers.forEach(teacher->log.info(teacher.toString()));
        log.info("\n\n\nend teachers\n\n\n\n\n");

        return new Forward("/service/teachers");
    }
}
