package com.solvd.app.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtendingThread extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(ExtendingThread.class);

    public void run() {
        LOGGER.info("Extending thread message: " + Thread.currentThread().getName());
    }
}
