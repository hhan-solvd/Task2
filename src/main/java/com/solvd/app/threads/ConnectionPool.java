package com.solvd.app.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static ConnectionPool instance = null;
    private final BlockingQueue<Connection> pool = new LinkedBlockingQueue<>();
    private static final int SIZE = 5;

    private ConnectionPool() {
        for (int i = 0; i < SIZE; i++) {
            pool.add(new Connection());
        }
    }

    // The pool is lazy initialized.
    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }

        return instance;
    }

    public void releaseConnection(Connection connection) {
        pool.offer(connection);
    }

    public Connection getConnection() throws InterruptedException {
        return pool.take();
    }
}
