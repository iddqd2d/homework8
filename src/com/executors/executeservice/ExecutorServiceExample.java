package com.executors.executeservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    private static ExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws Exception {
        Future future = service.submit(new GetName(1));

        if (!future.isDone()) {
            System.out.println("Getting name");
        }

        System.out.println("Result: " + future.get());
        service.shutdown();
    }
}
