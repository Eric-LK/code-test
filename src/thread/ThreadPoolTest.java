package thread;

import java.util.concurrent.*;

/**
 * 线程池练习
 *
 * @author: 刘兵
 * @date: 2020/7/12 9:53
 **/
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadFactory threadFactory = r -> new Thread("Eric");

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                threadFactory);

        threadPoolExecutor.execute(()->{
            System.out.println("hello word" + Thread.currentThread().getName());
        });
    }
}
