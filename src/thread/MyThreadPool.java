package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class MyThreadPool {
    // 一直在保持运行的线程数
    private List<WorkThread> workThreads;
    // 执行我们的任务队列容器
    private BlockingQueue<Runnable> tasks;
    // 任务开始结束标识
    private volatile boolean isWorking = true;

    // 构造函数
    public  MyThreadPool(int workThreads, int tasks){
        this.tasks =new LinkedBlockingDeque<Runnable>(tasks);
        // 提前预热，创建固定线程，一直保持运行的状态
        this.workThreads = new ArrayList<WorkThread>();
        for(int i = 0;i < workThreads;i++){
            WorkThread workThread = new WorkThread();
            workThread.start();
            this.workThreads.add(workThread);
        }
    }
    // 工作线程类
    class WorkThread extends Thread{
        public void run(){
            while(isWorking || tasks.size() > 0){
                // 从队列中取出任务，并执行
                Runnable task = tasks.poll();
                if (task != null){
                    task.run();
                }
            }
        }
    }
    // 开始任务
    public boolean execute(Runnable runnable){
        return tasks.offer(runnable);
    }
    // 结束任务
    private void shutDown(){
        this.isWorking = false;
    }

    public static void main(String[] args) {
        MyThreadPool threadPoolMYKT = new MyThreadPool(3,6);
        for(int i = 0;i < 10; i ++){
            int finalI = i;
            threadPoolMYKT.execute(new Runnable(){
                @Override
                public void run() {
                    System.out.println
                    (Thread.currentThread().getName() + 
                    "任务开始执行" + finalI);
                }
            });
        }
    }
}
