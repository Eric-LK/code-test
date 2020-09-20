package thread.imooc;

import java.util.concurrent.CountDownLatch;

/**
 * dfs
 *
 * @author: 刘兵
 * @date: 2020/8/23 16:05
 **/
public class CountdownLatchTest {
    private static  final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(5);
    public static void main(String[] args) throws InterruptedException {

        System.out.println("控球后卫到位！等待所有位置球员到位！");
        COUNT_DOWN_LATCH.countDown();

        new Thread(()->{
            System.out.println("得分后卫到位！");
            COUNT_DOWN_LATCH.countDown();
        }).start();

        new Thread(()->{
            System.out.println("中锋到位！");
            COUNT_DOWN_LATCH.countDown();
        }).start();

        new Thread(()->{
            System.out.println("大前锋到位！");
            COUNT_DOWN_LATCH.countDown();
        }).start();

        new Thread(()->{
            System.out.println("小前锋到位！");
            COUNT_DOWN_LATCH.countDown();
        }).start();

        COUNT_DOWN_LATCH.await();

        System.out.print("全部到位，开始进攻！");
    }
}
