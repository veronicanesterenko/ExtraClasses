package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Action;
import org.example.extraclasses.api.ActionFactory;
import org.example.extraclasses.api.Forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainAction extends Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return new Forward("/");
    }
}
