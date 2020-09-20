package random;

import org.junit.Test;

import java.util.Random;

/**
 * 随机数练习
 *
 * @author: 刘兵
 * @date: 2020/8/15 10:38
 **/
public class TestRandom {

    public static void main(String[] args) throws Exception{

        Random random = new Random();

        System.out.println(Math.random());
        System.out.println("-------------------------");
        System.out.println(1 + (int) (Math.random() * (10 - 2)));

        for (int i = 0; i < 2000000000; i++) {
             System.out.println(random.nextInt(10));
        }
        // Thread.sleep(1000000);
        // Thread thread =  Thread.currentThread().;

    }


    public void testOne(){
        Runtime run = Runtime.getRuntime();

        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long usableMemony = maxMemory - totalMemory + freeMemory;
        System.out.println("可以获得最大内存是："+ maxMemory/1024/1024 + "M");
        System.out.println("已分配到的内存大小是："+ totalMemory/1024/1024 + "M");
        System.out.println("所分配内存的剩余大小是："+ freeMemory/1024/1024 + "M");
        System.out.println("最大可用内存大小是："+ usableMemony/1024/1024 + "M");
    }
}
