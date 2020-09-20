package thread.synchronizedtest;

/**
 * synchronized 在上锁的时候，需要一个对象作为锁
 * @author lb
 */
public class TestOne implements Runnable{

    static Object objectSynchronized = new Object();

    volatile int count;

    @Override
    public void run() {
        synchronized (objectSynchronized){
            /// this.wait(1000);

            count ++;
        }
    }

}
