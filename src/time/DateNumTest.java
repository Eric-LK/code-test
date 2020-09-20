package time;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间练习
 * @author 17734
 */
public class DateNumTest {
    @Test
    public void test1(){
        // 一天的毫秒数
        long DAY = 24L * 60L * 60L * 1000L;
        // 时间格式化
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 现在的时间
        Date startDate = new Date();
        // 设置三天后的时间
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        /// c.add(Calendar.DATE,3);

        c.add(Calendar.HOUR,49);

        Date endDate = c.getTime();

        System.out.println(startDate);
        System.out.println(endDate);

        Long dayNumber1 = (endDate.getTime() + 1000 - startDate.getTime()) / DAY;
        System.out.println("1: "+dayNumber1);

        try {
             startDate = dateFormat.parse(dateFormat.format(startDate));
             endDate = dateFormat.parse(dateFormat.format(endDate));
            c.setTime(startDate); // 设置当前日期

            // c.add(Calendar.DATE, 3);
            c.add(Calendar.HOUR,49);

            Date endDate1 = c.getTime();

            System.out.println(startDate);
            System.out.println(endDate1);

            long endDouble = endDate1.getTime()+1000;
            long startDouble =  startDate.getTime();
            double dayNumber2 = ((double) endDouble - (double) startDouble) / DAY;
            int dayNumInt =(int)Math.ceil(dayNumber2);
            System.out.println("2: "+dayNumInt);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }



    }

}
