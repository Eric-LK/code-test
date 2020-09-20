package java_8.dateApi;

import java.time.*;

/**
 * @author lb
 */
public class Test01 {
    public static void main(String[] args) {
        // -------------------- Time ------------------- //


        LocalDate localDate = LocalDate.now();

        System.out.println("LocalDate : "+localDate);

        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        System.out.println( year + "--" + month + "--" + day);

        // 自定义时间
        LocalDate localDate1 = LocalDate.of(2020,5,20);
        System.out.println(localDate1);
        // 判断两个时间是否相等
        System.out.println(localDate.equals(localDate1));

    }
}
