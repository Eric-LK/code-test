package generic;

import generic.GenericMethod;

/**
 * @introduce: 泛型练习启动类
 * @author: liuBing
 * @date: 2020/6/5
 **/
public class MainClass {

    public static void main(String[] args) {
        GenericMethod t = new GenericMethod();
        System.out.println(t.showName("---- 456"));

        System.out.println("------------------------------------");
        System.out.println(t.showData(new GenericClass<String>("2222")));
        System.out.println(t.showData(new GenericClass<Integer>(123)));
    }
}
