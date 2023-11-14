package org.example.extraclasses.api;

import org.example.extraclasses.api.action.*;
import org.example.extraclasses.exception.FactoryException;
import org.example.extraclasses.util.Loggable;

import javax.servlet.ServletException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class ActionFactory implements Loggable {
    private static Map<String,Class<? extends Action>> actions = new HashMap<>();
    private final Logger log = getLogger();

    static {
        actions.put("/extra/main", MainAction.class);
        actions.put("/extra/service/teachers", ServiceTeachers.class);
        actions.put("/extra/service/teachers/add", AddTeacher.class);
        actions.put("/extra/service/students", ServiceStudents.class);
        actions.put("/extra/subject", Subject.class);
        actions.put("/extra/service", Service.class);
        actions.put("/extra/teachers", TeacherPage.class);
        actions.put("/extra/service/subjects/add", AddSubject.class);
        actions.put("/extra/service/subjects", ServiceSubject.class);
        actions.put("/extra/change-teacher", ChangeTeacher.class);
        actions.put("/extra/edit-description", EditDescription.class);

    }

    public static Action getAction(String uri) throws ServletException, FactoryException {
        Class<?> action = actions.get(uri);
        if (Objects.nonNull(action)) {
            try {
                return (Action) action.getDeclaredConstructors()[0].newInstance();
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                throw new ServletException(e);
            }
        }
        throw new ServletException("No actions found for uri: " + uri);
    }
}
