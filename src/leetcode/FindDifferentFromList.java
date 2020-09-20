package leetcode;

/**
 * @author liuBing
 */
public class FindDifferentFromList {

    // 找出数组中不重复的数
    // 01
    public int singleNumber(int[] numbers) {
        int i;
        for (i = 0; i < numbers.length; i++) {
            int b = 0;
            int a = numbers[i];
            for (int j = 0; j < numbers.length; j++) {
                if (j != i && numbers[j] == a) {
                    b = 1;
                    break;
                }
            }
            if (b == 0) {
                return a;
            }
        }
        return 0;
    }

    // 02
    public int singleNumberSecond(int[] numbers) {
        int num = 0;
        for (int j : numbers) {
            num = num ^ j;
        }
        return num;
    }
}
