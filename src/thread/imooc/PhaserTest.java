package thread.imooc;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 类似于 CountDownLatch 和 CyclicBarrier
 * 但是它可以动态的增加和删除任务
 *
 * @author lb
 */
public class PhaserTest {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        //主线程注册
        phaser.register();
        //10个学生线程分别启动开始考试，然后交卷，交卷后通知phaser已到达并且注销
        IntStream.range(1, 10).forEach(number -> {
            phaser.register();
            Thread student = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("学生" + number + "交卷");
                phaser.arriveAndDeregister();
            });
            student.start();
        });

        //学生并行考试时，主线程会先执行到此行代码，但由于本phase还没有达成，所以阻塞在此
        phaser.arriveAndAwaitAdvance();
        //所有学生达成后，开始新的phase，下面启动三个老师线程，开始判卷
        IntStream.range(1, 3).forEach(number -> {
            phaser.register();
            Thread teacher = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("老师" + number + "判卷完成");
                phaser.arriveAndDeregister();
            });
            teacher.start();
        });

        //老师判卷时，主线程会先执行到此行代码，但由于本phase还没有达成，所以阻塞在此
        phaser.arriveAndAwaitAdvance();
        //所有老师都达成后，开始新的phase，下面启动三个辅导员线程，公布成绩
        IntStream.range(1, 3).forEach(number -> {
            phaser.register();
            Thread counsellor = new Thread(() -> {
                System.out.println("辅导员" + number + "公布成绩完成");
                phaser.arriveAndDeregister();
            });
            counsellor.start();
        });
    }
}
