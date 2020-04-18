package com.ji.current;

/**
 * user ji
 * data 2020/4/8
 * time 12:57 PM
 */
public class MyMutex {
    private boolean isLocked = false;
    public static void main(String[] args) throws InterruptedException {
        MyMutex mutex = new MyMutex();
        mutex.lock();
        System.out.println("=============");
        mutex.unlock();
    }

    public synchronized void lock() throws InterruptedException {
        while (this.isLocked){
            wait();
        }
        this.isLocked = true;
    }

    public synchronized void unlock() throws InterruptedException{
        this.isLocked = false;
        this.notify();
    }
}
