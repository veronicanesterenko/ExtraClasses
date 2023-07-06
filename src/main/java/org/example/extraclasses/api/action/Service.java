package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Action;
import org.example.extraclasses.api.ActionFactory;
import org.example.extraclasses.api.Forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class Service extends Action {
    private final static Logger log = Logger.getLogger(Service.class.getName());
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Start action: "+Action.class.getName());
        return new Forward("/service");
    }
}
