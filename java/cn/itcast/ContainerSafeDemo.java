package cn.itcast;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerSafeDemo {

    public static void main(String[] args) {


        final List<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                public void run() {
                    list.add(UUID.randomUUID().toString().substring(0, 8));
                    System.out.println(list);
                }
            }, String.valueOf(i)).start();

//
//
// Exception in thread "22" java.util.ConcurrentModificationException  高并发修改异常

            //原因  并发争抢导致，，，
            //解决办法
            //1、 new Vector<String>()  add 方法  进行了枷锁
            //2 、 Collections.synchronizedList(new ArrayList())Collections.synchronizedList(new ArrayList())
            //3、  new CopyOnWriteArrayList<String>();  写诗复制
        }


    }
}
