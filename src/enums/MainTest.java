package enums;

import java.io.IOException;
import java.util.Scanner;

public class MainTest {

    //private static Object EnumTest02;

    enum EnumTest02{ jame,eric,tom;}

    public static void main(String[] args) throws IOException {
        /*System.out.println(EnumTest.one);
        System.out.println(EnumTest.two);
        System.out.println(EnumTest.TWO.getAge());
        System.out.println(EnumTest.THREE);
        System.out.println(EnumTest.TWO.show());

        EnumTest02 enumTest = EnumTest02.jame;

        String[] test01 = {"eric","tom","jame"};*/

        EnumTest enumTest = EnumTest.sdf;
        System.out.println(EnumTest02.jame);

        Scanner input = new Scanner(System.in);
        String test02 =input.nextLine();
        switch (test02){
            case "jame" :
                System.out.println("123");
                break;
            case "eric":
                System.out.println("456");
                break;
            case "tom":
                System.out.println("789");
                break;
            default:
                break;
        }
    }
}
