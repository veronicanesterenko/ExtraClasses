package org.example.extraclasses.api;

import org.example.extraclasses.util.Connector;
import org.example.extraclasses.util.ServiceFactory;
import org.example.extraclasses.util.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

@WebServlet(value = "/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(DispatcherServlet.class.getName());

    @Override
    public void init() throws ServletException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/extra?useUnicode=true&useSSL=false&characterEncoding=UTF-8";
        String user = "root";
        String password = "root";
        Connector.init(driver, jdbcUrl, user, password);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Start prosess, uri: " + request.getRequestURI());
        log.info("uri: " + request.getRequestURL());
        String uri = request.getRequestURI();
        String context = request.getContextPath();

        Action action = ActionFactory.getAction(uri);
        Forward forward;
        try (ServiceFactory factory = getServiceFactory()) {
            action.setServiceFactory(factory);
            log.info("action with serviceFactory: " + action);
            forward = action.execute(request, response);
            log.info("forward : " + forward);
        } catch (Exception e) {
            log.severe("OOPS: " + Arrays.toString(e.getStackTrace()));
            throw new ServletException(e);
        }
        log.info("forward: " + forward);


        if (Objects.nonNull(forward) && forward.isRedirect()) {
            response.sendRedirect(context + forward.getUri());
        } else {
            if (Objects.nonNull(forward) && forward.getUri() != null) {
                uri = forward.getUri();
            }
            request.getRequestDispatcher("/WEB-INF/jsp" + uri + ".jsp").forward(request, response);
        }
    }

    private ServiceFactory getServiceFactory() {
        return new ServiceFactoryImpl();
    }
}
