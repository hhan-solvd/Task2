package com.solvd.app.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public void connect(String threadName) {
        LOGGER.info(threadName + " is connected to the database.");
    }

    public void disconnect(String threadName) {
        LOGGER.info(threadName + " is disconnected from the database.");
    }
}
