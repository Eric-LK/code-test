package thread;

public class DeadThread{
    // 实例两个对象作为锁
    static Object obj1 = new Object();
    static Object obj2 = new Object();

    // 测试
    public static void main(String[] args){
        Thread t1 = new Thread(new Test(true));
        Thread t2 = new Thread(new Test(false));
        t1.start();
        t2.start();
    }
}
class Test implements Runnable{

    boolean flag;
    Test(boolean flag){
        this.flag = flag;
    }
    public void run(){
        if(flag){
            synchronized(DeadThread.obj1){
                System.out.println("if ");
                synchronized(DeadThread.obj2){
                    System.out.println("if a");
                }
            }
        }else{
            synchronized(DeadThread.obj2){
                System.out.println("else ");
                synchronized(DeadThread.obj1){
                    System.out.println("else b");
                }
            }
        }
    }
}

