package thread.imooc;

public class Student extends Thread{

    private String name;
    private Punishment punishment;

    public Student(String name,Punishment punishment) {
        this.name=name;
        this.punishment = punishment;
    }

    @Override
    public void run(){
        copyWord();
    }

    public void copyWord() {
        int count = 0;
        String threadName = Thread.currentThread().getName();

        while (true) {
            if (punishment.getLeftCopyCount() > 0) {
                int leftCopyCount = punishment.getLeftCopyCount();
                leftCopyCount--;
                if(leftCopyCount<punishment.getLeftCopyCount()){
                    punishment.setLeftCopyCount(leftCopyCount);
                }
                System.out.println(threadName+"线程-"+name + "抄写" + punishment.getWordToCopy() + "。还要抄写" + leftCopyCount + "次");
                count++;
            } else {
                break;
            }
        }

        System.out.println(threadName+"线程-"+name + "一共抄写了" + count + "次！");

    }

}



