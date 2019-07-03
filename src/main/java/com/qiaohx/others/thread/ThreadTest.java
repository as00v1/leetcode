package com.qiaohx.others.thread;

import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) {
        Things things = new Things();
        FutureTask<String> futureTask = new FutureTask<String>(things);
        new Thread(futureTask).start();
        while (!futureTask.isDone()){
            System.out.println("未完成，休眠5s");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("完成");
    }
}
