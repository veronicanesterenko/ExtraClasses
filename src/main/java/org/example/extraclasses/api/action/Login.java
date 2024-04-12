package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.service.subject.SubjectService;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class Login extends Action implements Loggable {
    private final Logger log = getLogger();
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Start action : "+this.getClass().getName());

        return new Forward("/login");
    }
}
