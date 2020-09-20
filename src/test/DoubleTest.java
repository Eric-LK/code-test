package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DoubleTest {


    @Test
    public void test1() throws InterruptedException {
        // Double a = 4.12501;
        // BigDecimal bg = new BigDecimal(a);
        // double a1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        // double a2 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        /*NumberFormat nf = NumberFormat.getNumberInstance();
         *//**
         * setMaximumFractionDigits(int newValue)
         设置数的小数部分所允许的最大位数。
         *//*
        nf.setMaximumFractionDigits(2);
        nf.format(a);*/

        // System.out.println(a1);
        // System.out.println(a2);

        int[] ints = new int[]{1, 2, 3};
        int[] ints1 = new int[3];
        ints1[0] = 123;
        ints1[1] = 456;
        ints1[2] = 789;

        int[] ints2 = new int[3];

        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));

    }


    @Test
    public void countDownLatchTest() throws InterruptedException {
        // 定义了一个门闩，需要要把钥匙就能打开
        CountDownLatch countDownLatch = new CountDownLatch(4);
        // 定义五个线程去解决它
        IntStream.range(0, 4).forEach(number -> {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + number);
                // 尝试开锁
                countDownLatch.countDown();
            }, "线程" + number).start();

        });
        countDownLatch.await();
        System.out.println("开车了");
    }

    Semaphore semaphore = new Semaphore(5);
    Random random = new Random();

    @Test
    public void semaphoreTest() {
        IntStream.range(0, 15).forEach(n -> {
            new Thread(() -> {
                // 占用资源
                try {
                    semaphore.acquire();
                    System.out.println("占用资源" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 随机生成资源占用的实践
                int parkingTime = random.nextInt(10) + 2;
                try {
                    TimeUnit.SECONDS.sleep(parkingTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 释放资源
                semaphore.release();
                System.out.println("释放资源" + Thread.currentThread().getName());
            }, "线程" + n).start();
        });
        // 让主线程睡一会，不然程序直接结束了，看不到效果
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void workmateTest() throws InterruptedException {
        Exchanger<String> workmate = new Exchanger<>();
        new Thread(() -> {
            try {
                //System.out.println("我的名字: " + Thread.currentThread().getName());
                String expressDocument = workmate.exchange("01");
                System.out.println(Thread.currentThread().getName()+"换到的名字："+ expressDocument);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-01").start();
        new Thread(() -> {
            try {
                String expressDocument = workmate.exchange("02");
                System.out.println(Thread.currentThread().getName()+"换到的名字：" + expressDocument);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-02").start();

        new Thread(() -> {
            try {
                String expressDocument = workmate.exchange("02");
                System.out.println(Thread.currentThread().getName()+"换到的名字：" + expressDocument);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-03").start();
        // 让主线程睡一会，不然程序直接结束了，看不到效果
        Thread.sleep(5000);
    }

    @Test
    public void cyclicBarrierTest() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("4个乘客到位，发车"));
        Stream.iterate(0, n -> n+1).limit(10).forEach(n -> {
            try {
                //TimeUnit.SECONDS.sleep(100);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "乘客已就位");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },n.toString()).start();
        });
        TimeUnit.SECONDS.sleep(10);
    }

}

