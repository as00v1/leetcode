package com.qiaohx.others.thread;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {
        // 固定大小线程池 core=max
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

        // 无限线程，每个job都创建一个线程
        //new ThreadPoolExecutor(0, Integer.MAX_VALUE,
        //                                      60L, TimeUnit.SECONDS,
        //                                      new SynchronousQueue<Runnable>());
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // 一次一个线程
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        fixedThreadPool.shutdown();
        cachedThreadPool.shutdown();
        singleThreadPool.shutdown();


        new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    }
                });
    }
}
