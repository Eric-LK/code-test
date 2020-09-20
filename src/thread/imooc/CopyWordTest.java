package thread.imooc;



public class CopyWordTest {

    public static void main(String[] args) {
        Punishment punishment = new Punishment(100,"internationalization");

        Student xiaoming = new Student("小明",punishment);
        xiaoming.start();

        Student xiaozhang = new Student("小张",punishment);
        xiaozhang.start();

        Student xiaozhao = new Student("小赵",punishment);
        xiaozhao.start();
    }

}
