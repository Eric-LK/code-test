package thread.imooc;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author lb
 */
public class FutureTest {

    public static void main(String[] args) throws Exception{
        // 定义一个购买小龙虾的任务
        FutureTask<String> cookTask = new FutureTask<>(() -> {
            Thread.sleep(5000);
            return "5斤的龙虾";
        });
        // 获取一下开始时间
        long startTime = System.currentTimeMillis();
        // 点小龙虾并开始做
        System.out.println("我点了5斤的龙虾。");
        new Thread(cookTask).start();
        // 去买牙膏
        System.out.println("我去买牙膏。");
        // 买牙膏的时间
        TimeUnit.SECONDS.sleep(2);
        System.out.println("我买到牙膏了！");
        // 买完牙膏获取一下时间
        long a = System.currentTimeMillis();
        // 查看小龙虾做好了没有
        String lunch = cookTask.get();
        System.out.println("我买完牙膏等待小龙虾" + (System.currentTimeMillis() - a )/1000 + "秒");
        System.out.println("我点的"+lunch+"已经OK了！");
        // 获取一共花了多长时间
        long userTime = (System.currentTimeMillis() - startTime)/1000;
        System.out.println("我一共用了"+userTime+"秒买午餐并且买牙膏。");
    }
}
