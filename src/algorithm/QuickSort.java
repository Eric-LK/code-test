package algorithm;

import java.util.Arrays;

/**
 * 快速排序练习
 *
 * @author: 刘兵
 * @date: 2020/8/16 10:33
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] ints = {1,-123,2323,4545,-343,55,903};
        quickSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    public static void one(int[] ints, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int p = ints[left];

        int temp;

        while (l < r) {
            // 从右到左
            while (ints[r] >= p && r > l) {
                r--;
            }
            ints[l] = ints[r];

            // 从左到右
            while (ints[l] <= p  && l < r) {
                l++;
            }
            ints[r]=ints[l];


        }

        ints[l] = p;

        one(ints, left, l - 1);
        one(ints, l + 1, right);
    }

    public static void quickSort(int[] array , int left , int right){
        if ( left >= right ){
            return;
        }
        int l = left;
        int r = right;
        // 获取第一个为基准值
        int p = array[l];

        while( l < r ){
            // 由于我们获取的第一个数据为基准值，所以我们从右向左先扫描
            // 这样第一个值就可以覆盖掉
            while( l < r && array[r] > p){
                r --;
            }
            array[l] = array[r];

            // 从左往右扫描
            while( l < r && array[l] < p){
                l ++;
            }
            array[r] = array[l];
        }
        // 将基准值放在属于它的位置
        array[l] = p;
        // 递归
        quickSort(array,left,l-1);
        quickSort(array,l+1,right);

    }
}
