package org.example.extraclasses.api.filter;


import org.example.extraclasses.util.Loggable;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(
        servletNames = {"org.example.extraclasses.api.DispatcherServlet"}
)
public class AuthFilter implements Filter, Loggable {
    ServletContext servletContext;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final Logger log = getLogger();
        log.info("Start auth........");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        final HttpSession session = req.getSession();
        final long lastAccessedTime = session.getLastAccessedTime();
        final long diff = System.currentTimeMillis() - lastAccessedTime;
        log.info("   Diff   " + diff);
        if(diff > 10000)
            resp.sendRedirect("/extra/login");
        else
            filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
