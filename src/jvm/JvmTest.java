package jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JvmTest {
    public static void main(String[] args) {
        /*long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println();

        String a =  System.getProperty("str");
        if (a == null){
            System.out.println("eric");
        }else {
            System.out.println(a);
        }*/

        Thread thread = new Thread(() -> {
            try {
                System.out.println("1");
                Thread.sleep(5000);
                System.out.println("2");
            } catch (InterruptedException e) {
                e.getCause();
            }
        });


        thread.start();
        //test01();
    }

    public static void test01() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            StringBuilder a = new StringBuilder();
            for (int j = 0; j < 1000; j++) {
                a.append(UUID.randomUUID().toString());
            }
            strings.add(a.toString());
        }
        System.out.println("ok");
    }
}
