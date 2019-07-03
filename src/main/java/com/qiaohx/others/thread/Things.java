package com.qiaohx.others.thread;

import java.util.concurrent.Callable;

public class Things implements Callable {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        System.out.println("开始执行一些事");
        Thread.sleep(30000);
        System.out.println("终于完了");
        return "完事";
    }
}
