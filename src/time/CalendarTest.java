package time;

import org.junit.Test;

import java.lang.annotation.Documented;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


/**
 * 时间类练习 Calendar 类
 *
 * @author liuBing
 */
public class CalendarTest {

    /**
     * 进行日期格式转换
     */
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    SimpleDateFormat dateFormatOne = new SimpleDateFormat("yyyy/MM/dd 123 HH~mm~ss");

    public static void main(String[] args) {
        Calendar calender = Calendar.getInstance();
    }

    @Test
    public void testDate() {
        Date date = new Date();
        System.out.println("date: " + date);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime: " + localDateTime);
        System.out.println(dateFormatOne.format(localDateTime));

        // DateTimeFormatter
        System.out.println(dateFormatOne.format(date));

    }

    @Test
    public void testSimpleDateFormat() throws Exception {
        Long start = System.currentTimeMillis();

        // 日期类型转换
        String dateOne = "2018-02-03 12:12:12";
        Date result = dateFormat.parse(dateOne);
        System.out.println(result);

        // 日期数据格式化
        String resultString = dateFormat.format(result);
        System.out.println(resultString);

        Date date = new Date();

        Long date1 = date.getTime();
        System.out.println(date1);

        System.out.println("方法消费时间：" + (System.currentTimeMillis() - start));
    }

    @Test
    public void testCalendar() {
        // calendar 是日历的意思
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());

        // Date date = calendar.get(Calendar.DATE);

        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        // LocalDateTime
    }
}
