package cn.itcast;

import java.util.concurrent.CountDownLatch;

//倒计数工具的使用
//让一些线程阻塞，直到另外一些线程完成一系列操作之后才被唤醒
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " \t 完成工作，离开");
                    countDownLatch.countDown();
                }
            }, CountEnumDemo.forEach(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " \t *****## 最后的人关灯，离开");
    }
}
