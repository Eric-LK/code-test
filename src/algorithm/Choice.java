package algorithm;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author: 刘兵
 * @date: 2020/7/14 8:14
 **/
public class Choice {

    public static void main(String[] args) {
        int[] ints = {1,3,5,2,4};
        System.out.println(Arrays.toString(choiceTest(ints)));
    }

    public static int[] choiceTest(int[] ints){
        int index ;
        int temp ;

        for (int i = 0 ; i < ints.length - 1; i++){
            index = i;
            for (int j = i ; j < ints.length - 1; j ++){
                if (ints[index] > ints[j + 1]){
                    index = j + 1 ;
                }
            }
            temp = ints[i];
            ints[i] = ints[index];
            ints[index] = temp;
        }
        return ints;
    }
}
