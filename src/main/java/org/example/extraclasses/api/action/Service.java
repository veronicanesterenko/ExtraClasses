package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Forward;
import org.example.extraclasses.util.Loggable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class Service extends Action implements Loggable {
    private final Logger log = getLogger();
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Start action: "+Action.class.getName());
        return new Forward("/service");
    }
}
