package java_8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class stream {
    @Test
    public void oldRunnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        }).start();
    }

    @Test
    public void runnable() {
        // 创建一个新的线程
        new Thread(() -> System.out.println("It's a lambda function!")).start();
    }

    @Test
    public void iterTest() {
        List<String> languages = Arrays.asList("java", "scala", "python");
        //before java8
        for (String each : languages) {
            System.out.println(each);
        }
        //after java8
        languages.forEach(x -> System.out.println(x));
        languages.forEach(System.out::println);
    }


    @Test
    public void zTest() {

        List<Integer> list = Arrays.asList(10, 20, 30, 40, 40, 20);

        // 1.对list中数据进行筛选操作
        List<Integer> listFilter = list.stream().filter(x -> x > 25).collect(Collectors.toList());

        // 2.对list中的每个数据操作一下，然后转化为list
        List<Integer> listMap = list.stream().map(x -> x + x * 5).collect(Collectors.toList());

        // 3.保留前3个元素
        List<Integer> listLimit = list.stream().limit(3).collect(Collectors.toList());

        // 4.跳过3个元素
        List<Integer> listSkip = list.stream().skip(3).collect(Collectors.toList());

        // 5.剔除重复元素
        List<Integer> listDistinct = list.stream().distinct().collect(Collectors.toList());

        // 6.sorted：对list中的元素进行流排序
        // 7.peek：流不变，会把每个元素传入进行操作，可以进行调试等操作
        List<Integer> listSorted =
                list.stream()
                        .sorted() //对list中的元素进行流排序
                        .peek(x -> {
                            if(x > 25){
                                System.out.println(x); //把每个大于25的数字打印出来
                            }}).collect(Collectors.toList());



        listFilter.forEach(System.out::println);
        System.out.println("2.对list中的每个数据操作一下，然后转化为list: " + listMap);
        System.out.println("3.保留前n个元素: " + listLimit);
        System.out.println("4.跳过n个元素: " + listSkip);
        System.out.println("5.剔除重复元素: " + listDistinct);
        System.out.println("6.对list中的元素进行流排序: " + listSorted);

        // 计算出最大值
        // Optional<Integer> doubleOptional = list.stream().max(Integer::compareTo);
        // System.out.println(doubleOptional);

    }

    @Test
    public void Test1() {

        List<Integer> list = Arrays.asList(10, 20, 30, 40, 40, 20);
        // 计算出最大值
        Optional<Integer> listMax = list.stream().max(Integer::compareTo);

        // 计算最小值
        Optional<Integer> listMin = list.stream().min(Integer::compareTo);

        // 返回第一个值
        Optional<Integer> listFirst = list.stream().findFirst();

        // 放回任意值
        Optional<Integer> listAny = list.stream().findAny();

        // 任何一个满足返回true
        boolean listAnyMatch = list.stream().anyMatch(x -> x > 25);

        // 所有满足返回true
        boolean listAllMatch = list.stream().allMatch(x -> x > 25);

        // 没有满足返回true
        boolean listNoneMatch = list.stream().noneMatch(x -> x > 25);

        // 累加器（x为0，然后y为list中的元素，他俩相加，然后付给x，最后返回下）
        Integer sum = list.stream().reduce(0,(x,y) -> x + y);
        Integer sumOther = list.stream().reduce(0, Integer::sum);

        System.out.println("计算出最大值: " + listMax);
        System.out.println("计算最小值: " + listMin);
        //System.out.println("计算长度: " + listCount);
        System.out.println("返回第一个值: " + listFirst);
        System.out.println("放回任意值: " + listAny);
        System.out.println("任何一个满足返回true: "+listAnyMatch);
        System.out.println("所有满足返回true: " + listAllMatch);
        System.out.println("没有满足返回true: " + listNoneMatch);
        System.out.println("累加器: " + sum);
        System.out.println("累加器: " + sumOther);

        List<Person> personList = Arrays.asList(
                new Person("张三", 12, "男"),
                new Person("李四", 13, "女"),
                new Person("王五", 14, "男"),
                new Person("赵六", 15, "女"),
                new Person("孙七", 16, "男"));

        Optional<Integer> minAge = personList.stream().map(Person::getAge).min(Integer::compareTo);
        System.out.println(minAge);



    }
    @Test
    public void test2(){
        List<String> listString = Arrays.asList("1","2","3");
        boolean flag= listString.stream().anyMatch("1"::equals);
        System.out.println(flag);
    }
}
