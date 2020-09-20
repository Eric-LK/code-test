package test;


/**
 * @introduce: 传递参数原理测试
 * @author: liuBing
 * @date: 2020/6/2
 **/
public class ParamTest {
    static Apple apple = new Apple();

    /**
     * String 和 基本类型的封装类型是不可变的
     * 只会生成新的
     */
    public static void main(String[] args) {
        Integer a = 300;
        test(apple, a);
        // 对象的属性是在堆中的
        System.out.println(apple.a);
        System.out.println(a);
    }

    static void test(Apple apple, Integer a) {
        apple.a += 1;
        a += 1;
    }
}

class Apple {
    int a = 200;
}
