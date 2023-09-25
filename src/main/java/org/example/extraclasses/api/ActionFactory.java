package org.example.extraclasses.api;

import org.example.extraclasses.api.action.*;
import org.example.extraclasses.service.subject.SubjectService;

import javax.servlet.ServletException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class ActionFactory {
    private static Map<String, Class<? extends Action>> actions = new HashMap<>();
    private static final Logger log = Logger.getLogger(ActionFactory.class.getName());

    static {
        actions.put("/extra/main", MainAction.class);
        actions.put("/extra/subject", Subject.class);
        actions.put("/extra/service", Service.class);
        actions.put("/extra/service/teachers", ServiceTeachers.class);
        actions.put("/extra/service/subjects", ServiceSubject.class);
        actions.put("/extra/teachers/add", AddTeacher.class);
        actions.put("/extra/teachers", TeacherPage.class);
        actions.put("/extra/subjects/add", AddSubject.class);
    }

    public static Action getAction(String uri) throws ServletException {
        Class<?> action = actions.get(uri);
        if (Objects.nonNull(action)) {
            try {
                log.info("constructor: " + Arrays.toString(action.getDeclaredConstructors()));
                return (Action) action.getDeclaredConstructors()[0].newInstance();
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                log.severe("Error during creation action: " + e.getMessage());
                throw new ServletException(e);
            }
        }
        throw new ServletException("No actions fond for: " + uri);
    }
}
