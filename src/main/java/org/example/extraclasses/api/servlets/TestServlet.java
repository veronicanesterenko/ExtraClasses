package org.example.extraclasses.api.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        // set the MIME type
        response.setContentType("text/html");

        // use this to print to browser
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>doGetdoPostdoPutServlet" + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1></h1>");
        out.println();
        out.println("</body>");
        out.println("</html>");
    }
}
