package com.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableExample {

    public static void main(String[] args) throws Exception {
        Callable task = () -> {
            int sum = 0;
            for (int i = 0; i < Byte.MAX_VALUE; i++, sum++) {
                Thread.sleep(1000);
            }
            return sum;
        };

        FutureTask future = new FutureTask(task);
        new Thread(future).start();
        System.out.println("You waited 127 seconds before you saw it:" + future.get());
    }
}
