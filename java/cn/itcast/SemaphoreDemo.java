package cn.itcast;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//信号量  一个用于多个共享资源的互斥使用  ，另外一个用于并发线程数的控制
public class SemaphoreDemo {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(4);
        for (int i = 1; i <= 6; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"\t 抢到了多了资源中的一个");
                    Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"\t 释放当前资源");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                       semaphore.release();
                    }
                }
            },CountEnumDemo.forEach(i).getName()).start();
        }
    }

}
