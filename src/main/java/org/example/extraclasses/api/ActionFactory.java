package org.example.extraclasses.api;

import org.example.extraclasses.api.action.MainAction;
import org.example.extraclasses.exception.FactoryException;

import javax.servlet.ServletException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class ActionFactory {
    private static Map<String,Class<? extends Action>> actions = new HashMap<>();
    private static final Logger log = Logger.getLogger(ActionFactory.class.getName());



    static {
        actions.put("/extra/subject/list", MainAction.class);
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
        throw new ServletException("No actions found");
    }
}
