package collection;

import java.util.ArrayList;
import java.util.HashSet;
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
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("123");
        hashSet.add("123");
        hashSet.add("111");

        System.out.println(hashSet);

        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("123");
        arrayList.add("123");
        System.out.println(arrayList);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("123");
    }
}
