package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class ServiceStudents extends Action {
    private final static Logger log = Logger.getLogger(ServiceTeachers.class.getName());
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Start action: "+ Action.class.getName());
        UserDao userDao = getServiceFactory().getUserDao();
        List<User> students = userDao.getAllByRole(Role.STUDENT);
        request.setAttribute("students",students);
        log.info("\n\n\nfound students\n\n\n\n\n");
        students.forEach(student->log.info(student.toString()));
        log.info("\n\n\nend students\n\n\n\n\n");


        return new Forward("/service/students");
    }
}
