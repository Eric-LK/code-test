package test;

import org.junit.Test;

/**
 * @author lb
 */
public class MathRandomClass {

    @Test
    public void showInt(){
        int b ;
        /*
         * random产生的随机数是 0 ~ 1 double类型的随机数
         *
         * */
        int a =(int) (1 + Math.random() * 10);
        if ( a > 5){
            b = 2;
            System.out.println(b);
        }
        System.out.println(a);
    }

}
