package collection;

import java.util.EnumSet;

/**
 * 枚举集合，只能存放指定枚举的枚举值
 */
public class EnumSetTest {

    public static void main(String[] args) {
        EnumSet<Season> es1 = EnumSet.noneOf(Season.class);

        print(es1);

        es1.add(Season.fall);
        es1.add(Season.winter);

        print(es1);
    }

    public static void print(Object o){
        System.out.println(o);
    }
}

enum Season{
    spring,summer,fall,winter
}

