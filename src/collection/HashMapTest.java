package collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * hashMap Test
 *
 * @author: 刘兵
 * @date: 2020/6/23 10:29
 **/
public class HashMapTest {

    public static void main(String[] args) {

    }

    @Test
    public void hashTestOne(){
        LinkedHashMap<String,String> hashMap ,hashMap1;//
        hashMap = new LinkedHashMap<>();
        hashMap.put("","");


        // 初始化的容量一定要是 2 的整数次幂
        HashMap<String,String> hashMapOne = new HashMap<>(4);

        /// hashMap.put("test","test");
        /// hashMap.put("test","123");

        hashMap.put("id","123");
        hashMap.put("name","eric");


        hashMap.put("id","456");

        System.out.println(hashMap);

        hashMap.put(null,"12222");
        hashMap.put(null,"123");

        hashMap.put("123","eric");

        for (String tmp : hashMap.keySet()){
            System.out.println(tmp);
        }

        System.out.println(hashMap);

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>(16);
        concurrentHashMap.put("key","value");
        System.out.println(concurrentHashMap);
    }

    /**
     * 证明初始化的 hashMap 都是2的整数次幂
     */
    @Test
    public void tableSizeForTest(){
        int a = -1 >>> Integer.numberOfLeadingZeros(12 - 1);
        System.out.println(a + 1);
    }

    @Test
    public void testOne(){
        int n = 0;
        System.out.println( n >>> 16);
    }

}
