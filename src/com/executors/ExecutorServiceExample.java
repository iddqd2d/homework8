package com.executors;

import java.util.concurrent.*;

public class ExecutorServiceExample {

    private static ExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws Exception {

        Future future = service.submit(() -> {
            System.out.println("Another Thread");
            Thread.sleep(1000);
            return "Select from BD";
        });

        if (!future.isDone()) {
            System.out.println("check another thread in main");
        }

        System.out.println("Result: " + future.get());
        service.shutdown();
    }
}
