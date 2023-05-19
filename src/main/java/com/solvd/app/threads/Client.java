package com.solvd.app.threads;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private static final int COUNT = 7;
    static ConnectionPool connectionPool = ConnectionPool.getConnection();
    static ExecutorService executorService = Executors.newFixedThreadPool(COUNT);

    public static void connect() {
        ArrayList<CompletableFuture<Void>> completableFutures = new ArrayList<>();

        for (int i = 0; i < COUNT; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                try {
                    Connection connection = connectionPool.addConnection();
                    String threadName = Thread.currentThread().getName();
                    connection.connect(threadName);
                    Thread.sleep(3000);
                    connection.disconnect(threadName);
                    connectionPool.removeConnection(connection);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, executorService);
            completableFutures.add(completableFuture);
        }

        // Join all the completableFutures
        CompletableFuture<Void> futures = CompletableFuture.allOf(completableFutures
                .toArray(new CompletableFuture[0]));
        futures.join();

        executorService.shutdown();
    }
}
