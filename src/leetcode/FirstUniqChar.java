package leetcode;

import java.util.List;

/**
 * @author liuBing
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("c"));
    }

    public static int firstUniqChar(String s) {

        char[] ss = s.toCharArray();
        if (ss.length == 1) {
            return 0;
        }

        for (int i = 0; i < ss.length - 1; i++) {
            int flag = 0;
            for (int j = i + 1; j < ss.length; j++) {
                if (ss[i] == ss[j]) {
                    flag++;
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }
}
