package cn.itcast;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//信号量  一个用于多个共享资源的互斥使用  ，另外一个用于并发线程数的控制
public class SemaphoreDemo {

    private static final Semaphore semaphore=new Semaphore(3);
    private static final ThreadPoolExecutor threadPool=new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());

    private static class InformationThread extends Thread{
        private final String name;
        private final int age;
        public InformationThread(String name,int age)
        {
            this.name=name;
            this.age=age;
        }

        public void run()
        {
            try
            {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+":大家好，我是"+name+"我今年"+age+"岁当前时间为："+System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println(name+"要准备释放许可证了，当前时间为："+System.currentTimeMillis());
                System.out.println("当前可使用的许可数为："+semaphore.availablePermits());
                semaphore.release();

            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        String[] name= {"李明","王五","张杰","王强","赵二","李四","张三"};
        int[] age= {26,27,33,45,19,23,41};
        for(int i=0;i<7;i++)
        {
            Thread t1=new InformationThread(name[i],age[i]);
            threadPool.execute(t1);
        }
    }

}
