package org.example.extraclasses.api.filter;

import org.example.extraclasses.util.Loggable;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

@WebFilter(description = "Test filter",
            displayName = "FirstWebFilter",
            servletNames = {"org.example.extraclasses.api.DispatcherServlet"})
public class MainWebFilter implements Filter, Loggable {
    private ServletContext servletContext;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
        Logger logger = getLogger();
        logger.info("Filter initialized...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        final Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                getLogger().info("c o o k i e {" + cookie.getName() + ": " + cookie.getValue() + "}");
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
