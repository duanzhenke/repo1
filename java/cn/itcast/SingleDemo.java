package cn.itcast;

import java.util.ArrayList;

public class SingleDemo {

    private static SingleDemo instance = null;

    private SingleDemo() {
        System.out.println("我是构造方法");
    }

    public static SingleDemo getInstance() {

        if (instance == null) {
            synchronized (SingleDemo.class) {
                if (instance == null) {
                    instance = new SingleDemo();
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {
//        System.out.println(SingleDemo.getInstance()==SingleDemo.getInstance());
//        System.out.println(SingleDemo.getInstance()==SingleDemo.getInstance());
//        System.out.println(SingleDemo.getInstance()==SingleDemo.getInstance());
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    SingleDemo instance = SingleDemo.getInstance();
                    System.out.println(Thread.currentThread().getName() + instance.hashCode());
                }
            }, String.valueOf(i)).start();

        }

    }
}
