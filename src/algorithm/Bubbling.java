package algorithm;

import java.util.Arrays;

/**
 * 冒泡算法
 *
 * @author: 刘兵1
 * @date: 2020/7/14 8:07
 **/
public class Bubbling {

    public static void main(String[] args) {
        int[] ints = {1,3,5,2,4};
        System.out.println(Arrays.toString(bubblingTest(ints)));
    }

    public static int[] bubblingTest(int[] ints){

        if (ints.length < 1){
            return ints;
        }

        int temp ;

        for(int i = 0 ; i < ints.length -1 ; i++){
            for(int j = i ; j < ints.length -1 ; j++){
                if (ints[j] > ints[j+1]){
                    temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }

        return ints;
    }
}
