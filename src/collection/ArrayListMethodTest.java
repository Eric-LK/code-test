package collection;

import java.util.*;

public class ArrayListMethodTest {
    public static void main(String[] args) {

        Set setTest = new HashSet();

        Map map = new Hashtable();

        ArrayList list01 = new ArrayList(2);
        list01.add(11);
        list01.add("11");
        System.out.println(list01.contains(11));
        System.out.println(list01.contains("11"));
        /*list01.add("123");
        list01.add(2);

        System.out.println(list01);

        list01.add(1,1);

        List list02 = new ArrayList();
        list02.add("123");
        list02.add("456");

        list01.add(list02);
        System.out.println("add Collection : " + list01);

        list01.add(4,list02);
        System.out.println("add index Collection : " + list01);

        Object listClone = list01.clone();
        System.out.println("Clone : " + listClone);

        list01.clear();

        System.out.println("是否包含 0 (contains):" +  list01.contains(0));
        System.out.println(list01.contains("123"));*/

        /*for (Object o : list01) {
            
        }*/

        int indexOf = list01.indexOf("11");

        Iterator iterator = list01.iterator();
        // iterator.forEachRemaining();
        System.out.println("Iterator :" + iterator);
    }
}
