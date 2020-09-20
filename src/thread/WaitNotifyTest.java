package thread;

/**
 * wait 和 notify 方法练习
 */
public class WaitNotifyTest {
    public static void main(String[] args){
        Eric e =new Eric();
        new Thread(new InPut(e)).start();
        new Thread(new Output(e)).start();
    }
}

class Output implements Runnable{
    private Eric eric;
    Output(Eric eric){
        this.eric = eric;
    }
    //@Override
    public void run() {
        while(true){
            eric.out();
        }
    }
}

class InPut implements Runnable{
    Eric eric ;
    InPut(Eric eric){
        this.eric = eric;
    }
    //@Override
    public void run() {
        int x = 0;
        while (true){
            if (x==0){
                eric.set("Eric","man");
            }else{
                eric.set("xin ling","woman");
            }
            x = (x+1)%2;
        }
    }
}

class Eric {
    private String name;
    private String sex;

    private boolean flag =false;
    public synchronized void  set(String name,String sex){
        if (flag){
            try{ this.wait(); } catch(Exception ignored){ }
        }
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }

    public synchronized void out(){
        if (!flag){
            try{this.wait();}catch(Exception ignored){}
        }
        System.out.println(name+"-----------"+sex);
        flag = false;
        this.notify();
    }
}