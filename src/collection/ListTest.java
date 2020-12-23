package collection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    /**
     * 有序，可以重复
     *
     * 3、Vector： 底层是数组，线程安全
     * 它有一种特殊的取出方式，枚举取出方式（早期的迭代器），它已经被ArrayList替代。
     */
    @Test
    public void Show(){
        String a = "123";

        /*
        * 1、ArrayList：使用的集合结构，查询速度快，但是添加删除慢，底层是数组，线程不安全。一般用这个。
        *
        * */
        List<String> stringList = new ArrayList<>();
        stringList.add("2");
        stringList.add("6");
        stringList.add("4");
        stringList.add("7");
        stringList.add("8");
        stringList.add("1");

        // 迭代器遍历集合
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            // 删除上一个next的值
            // iterator.remove();
            // System.out.println(iterator);
            // System.out.println(stringList);
        }
        // for 循环迭代集合
        /*for(String s:stringList){
            System.out.println(s);
        }*/

        //System.out.println(stringList);

        // java 8 最新的遍历方法
        iterator.forEachRemaining(str -> System.out.println("我的值是： " + str));

        System.out.println("------------------ removeIf ----------------");
        // 删除满足条件的值
        stringList.removeIf(ele ->ele.length()>4);
        stringList.forEach(System.out::println);

        // ---------------------- list.sort() -----------------
        System.out.println("---------------------- list.sort() -----------------");
        // Collections.sort(stringList);
        stringList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        stringList.forEach(System.out::println);

        Vector<String> vector = new Vector<>();
        vector.add("123");


        /*
        * 2、LinkedList：使用的是链表结构，删除和添加快，但是查询慢，底层是链表，底层不安全。
        * */
        /* Set<String> stringSet = new HashSet<>();
        stringSet.add("1");
        boolean flag = stringSet.stream().anyMatch( x -> x.equals("1"));
        System.out.println(flag);*/



        System.out.println("------------------ WeakHashMap --------------");
        Map<String,Object> mapTest = new WeakHashMap<String,Object>();
        mapTest.put(new String("123"),456);
        mapTest.put("java",123);

        System.gc();
        System.runFinalization();
        mapTest.keySet().forEach(System.out::println);
    }

    @Test
    public void test() throws Exception{
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("name","lk");
        String value = treeMap.firstEntry().getValue();
        System.out.println(treeMap);

        Properties properties = new Properties();
        properties.setProperty("name","eric");
        properties.setProperty("age","18");

        properties.store(new FileOutputStream("a.ini"),"comment line");

        properties.load(new FileInputStream("a.ini"));
        System.out.println(properties);

        HashMap<String,String> hashMap = new HashMap(17);

        ArrayList arrayList = new ArrayList();
        arrayList.add(123);

        float a = 3.4f;

        char a1 = '士';
    }

    @Test
    public void LinkedList1(){
        List list = new LinkedList();
        list.add("123");

        list.add("234");

        list.add("123");

        System.out.println(list);

        List liston = (List) list.stream().distinct().collect(Collectors.toList());


        // TreeSet

        System.out.println(liston);
        // System.out.println(list.get(2));

        HashSet hashSet = new HashSet();
        hashSet.add(123);
        // hashSet.

        String[] a = {"123","222"};
        List<String> listON = new ArrayList<>();

        // Collectoions.addAll()
    }

}
