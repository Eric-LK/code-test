package thread.synchronizedtest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自己手写的死锁
 *
 * @author lb
 */
public class MyDeadLock {
    static Object o1 = new Object();
    static Object o2 = new Object();


    public void test() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.incrementAndGet();

        Integer integer = 1;
        integer = integer + 1;
        // 以上两个操作，从结果上是等价的
    }


    public static void main(String[] args) {
        new Thread(new Lock1()).start();
        new Thread(new Lock2()).start();
        new Thread(() -> {

        }).start();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.incrementAndGet();

        Integer integer = 1;
        integer = integer + 1;
    }

    static class Lock1 implements Runnable {
        @Override
        public void run() {
            synchronized (o1) {
                System.out.println("get o1");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("get o2");
                }
            }
        }
    }

    static class Lock2 implements Runnable {
        @Override
        public void run() {
            synchronized (o2) {
                System.out.println("get o2");
                synchronized (o1) {
                    System.out.println("get o1");
                }
            }
        }
    }
}
