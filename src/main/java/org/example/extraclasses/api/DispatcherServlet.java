package org.example.extraclasses.api;

import org.example.extraclasses.api.action.Action;
import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.util.Connector;
import org.example.extraclasses.util.ServiceFactory;
import org.example.extraclasses.util.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

@WebServlet(value = "/")
@MultipartConfig
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(DispatcherServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (FactoryException e) {
            log.warning(e.toString());
        }
    }

    @Override
    public void init() throws ServletException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/extra?useUnicode=true&useSSL=false&characterEncoding=UtF-8";
        String user = "root";
        String password = "root";
        Connector.init(driver, jdbcUrl, user, password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (FactoryException e) {
            log.warning(e.toString());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, FactoryException, IOException {
        log.info("Start process, uri: " + request);
        log.info("Start process, uri: " + request.getRequestURL());

        String uri = request.getRequestURI();
        String context = request.getContextPath();
        log.info("this is URI    :" + uri);
        log.info("this is Context PATH     :" + context);
        Action action = ActionFactory.getAction(uri);
        Forward forward;
        try (ServiceFactory factory = getServiceFactory()) {
            action.setServiceFactory(factory);
            forward = action.execute(request, response);
        } catch (Exception e) {
            log.severe("oops" + Arrays.toString(e.getStackTrace()));
            throw new ServletException(e);
        }

        log.info("uri before "+uri);
        if (Objects.nonNull(forward) && forward.isRedirect()) {
            response.sendRedirect(context + forward.getUri());
            log.info("uri before 2 "+uri);
            return;
        } else {
            if (Objects.nonNull(forward) && forward.getUri() != null) {
                uri = forward.getUri();
                log.info("uri"+uri);
                log.info("request"+request);
            }
        }

        log.info("forward:" + forward);
        request.getRequestDispatcher("/WEB-INF/jsp/" + uri + ".jsp").forward(request, response);
        log.info("response"+response);
    }


    private ServiceFactory getServiceFactory() {
        return new ServiceFactoryImpl();
    }

}
