package com.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableExample {
    private static int sum;

    public static void main(String[] args) throws Exception {
        Callable task = () -> {
            for (int i = 0; i < Byte.MAX_VALUE; i++) {
                Thread.sleep(1000);
                sum += i;
            }
            return sum;
        };

        FutureTask future = new FutureTask(task);
        new Thread(future).start();
        System.out.println("You waited 127 seconds before you saw it:" + future.get());
    }
}
