package algorithm;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author: 刘兵
 * @date: 2020/7/14 8:34
 **/
public class Insert {

    public static void main(String[] args) {
        int[] ints = {1,3,5,2,4};
        System.out.println(Arrays.toString(insertTest(ints)));
    }

    public static int[] insertTest(int[] ints){

        int j ;

        for(int i = 1 ; i < ints.length ; i++){
            int temp = ints[i];
            for ( j = i - 1 ; j >= 0 && ints[j] > temp ; j--){
                ints[j + 1] = ints[j];
            }
            ints[j + 1] = temp;
        }
        return ints;
    }
}
