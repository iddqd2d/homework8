package com.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        service.scheduleAtFixedRate(new dbManager(), 0, 1, TimeUnit.DAYS);
    }

    private static class dbManager implements Runnable {
        @Override
        public void run() {
            System.out.println("cleaning old data");
        }
    }

}
