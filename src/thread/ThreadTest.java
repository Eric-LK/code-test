package thread;


import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 17734
 */
public class ThreadTest {
    public static void main(String[] args) {
        /*RunTest run = new RunTest();
        Thread thread1 = new Thread(run);
        thread1.start();

        Executor executor = Executors.newFixedThreadPool(10);

        executor.execute(()->{
            System.out.println("sf");
        });
        */
        /*ThreadLocal<String> name = ThreadLocal.withInitial(()->{
            return "eric";
        });*/
        /// ConcurrentHashMap

        Thread test01 = new Thread(() ->{
            test.userId.set("thread 01");
            test.userId.remove();
        },"01");

        Thread test02 = new Thread(() ->{
           test.userId.set("thread 02");
        },"02");

         System.out.println(test.userId.get());

        SoftReference<Object> o = new SoftReference<>(new Object());

        WeakReference<Object> o1 = new WeakReference<>(new Object());

        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        PhantomReference<Object> o3 = new PhantomReference<Object>(new Object(),referenceQueue);

    }
    static class RunTest implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1500; i++) {
                System.out.println("this is run1");
            }
        }
    }
}
class test{
    public static ThreadLocal<String> userId = new ThreadLocal<>();
}



