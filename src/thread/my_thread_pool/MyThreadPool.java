package thread.my_thread_pool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyThreadPool {

    /**
     * 工作过程：
     * 1、初始化一个任务队列
     * 2、定义一个集合用于存放线程，并初始化线程个数
     * 3、向线程池中添加线程
     * 4、向队列中添加任务
     * 5、线程从任务队列中获取第一个任务进行执行
     */

    private  final int poolSize;

    private final RunnableTaskQueue runnableTaskQueue;

    private final List<Thread> threads = new ArrayList<>();

    /**
     * 初始化线程池
     * @param poolSize 初始化线程队列长度
     */
    public MyThreadPool(int poolSize) {
        this.poolSize = poolSize;
        runnableTaskQueue = new RunnableTaskQueue();
        // 一个一个往里加，直到最大值
        Stream.iterate(1,item -> item + 1).limit(poolSize).forEach(item->{
            initThread();
        });
    }

    /**
     * 初始化线程
     * 任务一个一个往里加
     */
    private void initThread() {
        if (threads.size() <= poolSize){
            Thread thread = new Thread(()->{
                while (true) {
                    try{
                        Runnable task = runnableTaskQueue.getTask();
                        task.run();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
    }

    /**
     * 把线程加入线程池
     * @param runnable 加好任务的线程
     */
    public void execute(Runnable runnable){
        runnableTaskQueue.addTask(runnable);
    }

}
