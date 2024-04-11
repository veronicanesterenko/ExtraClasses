package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.ErrorManager;
import java.util.logging.Logger;

import static org.example.extraclasses.enums.RequestParam.ERROR_MESSAGE;

public class CheckLogin extends Action implements Loggable {
    private final Logger log = getLogger();

    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Start action : " + this.getClass().getName());
        String name = "admin";
        String pass = "admin";

        final String login = request.getParameter("login");
        final String password = request.getParameter("password");

        if (login.equals(name) && pass.equals(password))
            return new Forward("/main");
        else {
            request.setAttribute(ERROR_MESSAGE.val(), "incorrect login or password");
            return new Forward("/error");
        }


    }
}