package collection;

import org.junit.Test;

import java.util.PriorityQueue;

public class QueueTest {

    /**
     * 队列练习，此队列 按照元素的大小顺序排列 （从小到大——升序）, 即使是字符串也会排序（按照首字母排序）
     */
    @Test
    public void priorityQueueTest(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.offer(2);
        priorityQueue.offer(32);
        priorityQueue.offer(-23);
        priorityQueue.offer(233);
        System.out.println(priorityQueue);
        // 获取头元素不删除
        Integer a = priorityQueue.peek();
        System.out.println(a);
        System.out.println(priorityQueue);
        // 获取头元素删除
        priorityQueue.poll();
        System.out.println(priorityQueue);

        PriorityQueue<String> priorityQueue1 = new PriorityQueue<String>();
        priorityQueue1.offer("收到回复");
        priorityQueue1.offer("收到回的撒方法复");
        priorityQueue1.offer("大师傅但是");
        priorityQueue1.offer("啊收到回复");
        System.out.println(priorityQueue1);
    }

}
