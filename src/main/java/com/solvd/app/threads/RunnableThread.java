package com.solvd.app.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableThread implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(RunnableThread.class);

    public void run() {
        LOGGER.info("Runnable thread message: " + Thread.currentThread().getName());
    }
}
