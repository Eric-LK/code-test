package design.single.lazy;

/**
 * 懒汉模式
 * 什么时候需要时候实例化，不安全，而且synchronized降低效率
 *
 * @author 刘兵
 */
public class LazySingleOne {
    private static LazySingleOne single;

    private LazySingleOne() {
        if (single == null) {
            synchronized (LazySingleOne.class) {
                if (single == null) {
                    single = new LazySingleOne();
                }
            }
        }
    }
}
