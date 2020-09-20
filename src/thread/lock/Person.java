package thread.lock;

/**
 * @author lb
 */
public class Person {
    private boolean flag = true;

    public void start(){
        new Thread( ()->{
            int i =1;
            System.out.println(flag);
            while (flag) {
                i ++;
            }
            System.out.println(flag);
        }).start();
    }
    public void end(){
        flag = false;
    }
}
