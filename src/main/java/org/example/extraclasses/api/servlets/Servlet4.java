package org.example.extraclasses.api.servlets;

import org.example.extraclasses.dao.impl.SubjectDaoImpl;
import org.example.extraclasses.entity.SubjectInfo;
import org.example.extraclasses.service.subject.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/subjects"})
public class Servlet4 extends HttpServlet {
    private final SubjectService subjectService = new SubjectService(new SubjectDaoImpl());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SubjectInfo> subjects = subjectService.getAll();
        request.setAttribute("subjects", subjects);
        request.setAttribute("subject", "subjects");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/subject/list.jsp").forward(request, response);
    }
}
