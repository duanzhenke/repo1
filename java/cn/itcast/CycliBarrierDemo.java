package cn.itcast;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycliBarrierDemo {
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+"所有人到齐了之后，才能开始吃饭");
            }
        });

        for (int i = 1; i <=7; i++) {
          final   int temp =i;
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"\t 等候到了"+temp+"到了");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }

}
