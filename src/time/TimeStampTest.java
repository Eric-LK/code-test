package time;

/**
 * @author liuBing
 */
public class TimeStampTest {
    public static void main(String[] args) {
        System.out.println((System.currentTimeMillis() + 86400000L * 365) + "");
        long oneYearOld = System.currentTimeMillis() + 86400000L * 365 * 2;
        System.out.println(oneYearOld);
        System.out.println((int) ((oneYearOld - (System.currentTimeMillis() + 86400000L ) ) / (86400000L * 365)));
        System.out.println((int) ((oneYearOld - System.currentTimeMillis() ) / (86400000L * 365)));
        System.out.println(System.currentTimeMillis());
    }
}
