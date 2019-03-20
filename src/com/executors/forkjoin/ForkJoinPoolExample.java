package com.executors.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {
    public static final long NUM_OF_OPERATION = 1_000_000_000L;
    public static final int CORE = Runtime.getRuntime().availableProcessors();
    private static ForkJoinPool pool = new ForkJoinPool(CORE);

    public static void main(String[] args) {
        System.out.println(pool.invoke(new MyFork(0, NUM_OF_OPERATION)));
    }

}
