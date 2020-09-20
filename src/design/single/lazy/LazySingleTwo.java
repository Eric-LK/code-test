package design.single.lazy;

/**
 * 两重保险保证懒汉模式线程安全
 *
 * @author: liuBing
 * @date: 2020/6/1
 **/
public class LazySingleTwo {
    public static LazySingleTwo lazySingleTwo;

    private LazySingleTwo() {
    }

    public static LazySingleTwo getInstance() {
        if (lazySingleTwo == null) {
            synchronized (LazySingleTwo.class) {
                if (lazySingleTwo == null) {
                    lazySingleTwo = new LazySingleTwo();
                }
            }
        }
        return lazySingleTwo;
    }
}
