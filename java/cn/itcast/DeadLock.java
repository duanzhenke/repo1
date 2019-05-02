package cn.itcast;

public class DeadLock {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();
    }

    static class HoldLockThread implements Runnable {
        private String lockA = "lockA";
        private String lockB = "lockB";

        public HoldLockThread(String lockA, String lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        public void run() {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "自己持有"+lockA + "尝试获取锁"+lockB);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "自己持有"+lockB + "尝试获取锁"+lockA);
                }
            }
        }
    }

}
