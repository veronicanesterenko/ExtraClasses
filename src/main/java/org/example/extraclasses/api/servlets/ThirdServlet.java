package org.example.extraclasses.api.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

public class ThirdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String s = request.toString();
        request.getAuthType();

        pw.println("<html>");
        pw.println("<title>My Page</title>");
        pw.println("<h1>"+s+"</h1>");
        pw.println("<h1>request.getAuthType() "+request.getAuthType()+"</h1>");
        pw.println("<h1>request.getContextPath() "+request.getContextPath()+"</h1>");
        pw.println("<h1>request.getMethod() "+request.getMethod()+"</h1>");
        pw.println("<h1>request.getRemoteUse() "+request.getRemoteUser()+"</h1>");
        pw.println("<h1>request.getQueryString() "+request.getQueryString()+"</h1>");
        pw.println("<h1>request.getRequestURI() "+request.getRequestURI()+"</h1>");
        pw.println("<h1>request.getProtocol() "+request.getProtocol()+"</h1>");
        pw.println("<h1>request.getSession() "+request.getSession()+"</h1>");
        pw.println("<h1>request.getContentType() "+request.getContentType()+"</h1>");
        pw.println("<h1>request.getCookies() "+ Arrays.toString(request.getCookies())+"</h1>");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s1 = headerNames.nextElement().toString();
            pw.println("<h1>"+ s1 + " : "+ request.getHeader(s1)+"</h1>");

        }
       pw.println("<html>");

    }
}
