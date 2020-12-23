package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * set 练习
 *
 * @author: 刘兵
 * @date: 2020/6/18 15:27
 **/
public class SetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>(0);
        System.out.println(hashSet.size());
        hashSet.add("123");
        hashSet.add("123");
        hashSet.add("111");

        System.out.println(hashSet.size());

        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("123");
        arrayList.add("123");
        System.out.println(arrayList);

        System.out.println("-------------------");



    }
}
