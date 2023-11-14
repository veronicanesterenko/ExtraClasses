package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.SubjectDao;
import org.example.extraclasses.dao.UserDao;
import org.example.extraclasses.dao.impl.SubjectDaoImpl;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.entity.User;
import org.example.extraclasses.enums.Role;
import org.example.extraclasses.service.subject.SubjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static org.example.extraclasses.enums.RequestParam.*;

public class Subject extends Action {

    Logger log = Logger.getLogger(Subject.class.getName());
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Start action: "+Action.class.getName());

        String subject_name = request.getParameter("subject_name");
        SubjectService subjectService = getServiceFactory().getSubjectService();
        SubjectInfo subject = subjectService.findByName(subject_name);
        log.info("This S U B J E C T " +subject.toString());
        UserDao userDao = getServiceFactory().getUserDao();
        int teacherId = userDao.getTeacherIdBySubjectId(subject.getId());
        log.info("id: "+ request);
        User teacher = userDao.findById(String.valueOf(teacherId));
        log.info("Teacher"+ teacher);

        List<User> listOfTeachers = userDao.getAllByRole(Role.TEACHER);


        if(subject==null) {
            request.setAttribute(ERROR_MESSAGE.val(), "Subject not found by name: "+subject_name);
            return new Forward("/error");
        }

        request.setAttribute(SUBJECT_NAME.val(),subject);
        request.setAttribute(TEACHER.val(), teacher);
        request.setAttribute(TEACHERS.val(), listOfTeachers);
        return new Forward("/subject");

    }
}
