package com.executors;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {
    private static long numOfOperation = 1_000_000_000L;
    private static int core = Runtime.getRuntime().availableProcessors();
    private static ForkJoinPool pool = new ForkJoinPool(core);

    public static void main(String[] args) {
        System.out.println(pool.invoke(new MyFork(0, numOfOperation)));
    }

    static class MyFork extends RecursiveTask<Long> {
        private long from;
        private long to;

        MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from <= numOfOperation / core) {
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            } else {
                long middle = (to + from / 2);
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secodHalf = new MyFork(middle + 1, to);
                long secondValue = secodHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}
