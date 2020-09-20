package design.single.lazy;

/**
 * 懒汉式匿名内部类单例模式
 *
 * @author: liuBing
 * @date: 2020/6/1
 **/
public class LazySingleInnerClass {
    private LazySingleInnerClass() {
    }
    public static class InnerClass {
        public static final LazySingleInnerClass LAZY_SINGLE_INNER_CLASS = new LazySingleInnerClass();
    }

    public static LazySingleInnerClass getInstance() {
        return InnerClass.LAZY_SINGLE_INNER_CLASS;
    }
}
