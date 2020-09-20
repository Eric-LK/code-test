package jvm;



public class JvmTest2 {

    public static void main(String[] args) {
        new Thread(()->{
            try {
                System.out.println("213");

                // 获取所有线程的堆栈信息
                System.out.println(Thread.getAllStackTraces());

                 Thread.sleep(1000000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
