package org.example.extraclasses.util;

import java.util.logging.Logger;

public interface Loggable {
    default Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }
    default void logAction() {
        getLogger().info("Start action: " + this.getClass().getName());
    }
}
