package org.example.extraclasses.api;

import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.util.Connector;
import org.example.extraclasses.util.ServiceFactory;
import org.example.extraclasses.util.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

@WebServlet(value = "/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(DispatcherServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req,resp);
        } catch (FactoryException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbsUrl = "jdbc:mysql://localhost:3306/extra?useUnicode=true&useSSL=false&charaterEncoding=UtF-8";
        String user = "root";
        String password = "root";
        Connector.init(driver,jdbsUrl,user,password);
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

    private void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, FactoryException, IOException {
        log.info("Start process, url: " +request);
        log.info("Start process, url: " +request.getRequestURL());
        String url = request.getRequestURI();
        String context = request.getContextPath();

        Action action = ActionFactory.getAction(url);
        Forward forward = null;
        try(ServiceFactory factory=getServiceFactory()) {
            action.setServiceFactory(factory);
            forward = action.execute(request,response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
        if (Objects.nonNull(forward)&&forward.isRedirect()) {
            response.sendRedirect((context+forward.getUrl()));

        } else {
            if(Objects.nonNull(forward) && forward.getUrl() !=null) {
                url = forward.getUrl();

            }
            request.getRequestDispatcher("/WEB-INF/jsp"+url+"jsp");
        }

    }

    private ServiceFactory getServiceFactory() {
        return new ServiceFactoryImpl();
    }

    }
