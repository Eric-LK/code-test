package leetcode;

/**
 * @author liuBing
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] a = {'1', '2', '3','4'};

        System.out.println(reverseString(a));
    }

    public static char[] reverseString(char[] s) {
        int length = s.length;
        int a = length / 2;

        for (int i = 0; i < a; i++) {
            char temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }

        return s;
    }
}
