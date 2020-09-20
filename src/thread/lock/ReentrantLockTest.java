package thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * @author lb
 */
public class ReentrantLockTest {

    static ReentrantLock reentrantLock = new ReentrantLock();
    static boolean flagA = true;

    public static void main(String[] args) throws InterruptedException {

        Person person = new Person();
        person.start();
        /// Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(2);
        person.end();

    }

    public static void test1(){
        try {
            boolean flag = reentrantLock.tryLock(1,TimeUnit.SECONDS);
            if (flag){
                Stream.iterate(1,item -> item +1).limit(2).forEach(item->{
                    System.out.println(item + "----" + Thread.currentThread().getName());
                });
                TimeUnit.SECONDS.sleep(2);
            }else {
                System.out.println("time out! --- " + Thread.currentThread().getName());
            }
            /// Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
