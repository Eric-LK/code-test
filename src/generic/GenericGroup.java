package generic;

import java.util.ArrayList;

/**
 * 泛型数组练习
 *
 * @author: 刘兵
 * @date: 2020/6/6 20:51
 **/
public class GenericGroup {
    /*
     * 泛型数组的创建：
     * 可以声明带泛型的数组引用，但是不能直接创建带有泛型的数组对象
     *
     * 可以通过Array.newInstance(Class<T>,int)来创建T[]数组
     *
     *
     *
     */


    public static void main(String[] args) {
        ArrayList[] arrayLists = new ArrayList[5];

        ArrayList<String>[] arrayList = arrayLists;

    }
}
