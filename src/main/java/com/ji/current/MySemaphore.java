package com.ji.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * user ji
 * data 2020/4/8
 * time 12:52 PM
 */
public class MySemaphore {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(10);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int index = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();
                        System.out.println("Accessing: "+index);
                        Thread.sleep((long)(Math.random()*1000));
                        semaphore.release();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            service.execute(run);
        }
        service.shutdown();
    }

}
