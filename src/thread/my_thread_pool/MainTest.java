package thread.my_thread_pool;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(2);

        Stream.iterate(1,item -> item + 1).limit(10).forEach(
                item ->{
                    myThreadPool.execute(()->{
                        try{
                            System.out.println(Thread.currentThread().getName() + "exectue this task");
                            TimeUnit.SECONDS.sleep(2);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    });
                }
        );
    }
}
