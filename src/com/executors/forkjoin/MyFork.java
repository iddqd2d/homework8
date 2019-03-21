package com.executors.forkjoin;

import java.util.concurrent.RecursiveTask;
import static com.executors.forkjoin.ForkJoinPoolExample.CORE;
import static com.executors.forkjoin.ForkJoinPoolExample.NUM_OF_OPERATION;

public class MyFork extends RecursiveTask<Long> {
    private long from;
    private long to;

    MyFork(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        if (to - from <= NUM_OF_OPERATION / CORE) {
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
