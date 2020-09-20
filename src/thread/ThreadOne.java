package thread;



public class ThreadOne {
    public static void main(String[] args){

        Thread oneToTen = new Thread(new OneToTen());
        Thread tenToTwenty = new Thread(new TenToTwenty());
        oneToTen.start();
        tenToTwenty.start();
    }
}

class OneToTen implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <100000;i++){
            System.out.println(i);
        }
    }
}

class TenToTwenty implements Runnable{

    @Override
    public void run() {
        for (int i = 100000; i <200000 ;i++){
            System.out.println(i);
        }
    }
}
