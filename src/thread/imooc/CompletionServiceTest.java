package thread.imooc;

import java.util.concurrent.*;
import java.util.stream.Stream;

public class CompletionServiceTest {

    public static void main(String[] args) throws Exception{
        // 定义一个定长的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        // 将线程池加上一个特定的功能
        CompletionService<String> service = new ExecutorCompletionService<String>(pool);
        // 通过流的方式对数据线程并发操作
        Stream.of("苹果", "梨", "葡萄", "桃")
                .forEach(fruit -> service.submit(() -> {
                            if(fruit.equals("苹果")){
                                TimeUnit.SECONDS.sleep(6);
                            }else if(fruit.equals("梨")){
                                TimeUnit.SECONDS.sleep(1);
                            }else if(fruit.equals("葡萄")){
                                TimeUnit.SECONDS.sleep(10);
                            }else if(fruit.equals("桃")){
                                TimeUnit.SECONDS.sleep(3);
                            }
                            return "洗干净的"+fruit;
                        })
                );

        String result;
        while((result=service.take().get())!=null){
            System.out.println("吃掉"+result);
        }
    }
}
