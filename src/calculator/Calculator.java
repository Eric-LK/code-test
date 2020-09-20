package calculator;


import java.lang.reflect.Method;
import java.util.Scanner;

import static java.lang.Class.forName;

/**
 * 计算器主类
 *
 * @author liuBing
 * @Date 2019/12/9  19:11
 */
public class Calculator {

    public static void main(String[] args) {
        try {

            Scanner input = new Scanner(System.in);

            while(true){
                System.out.println("请输入第一个数字：");
                String a = input.nextLine();

                System.out.println("请输入运算符：");
                String test = input.nextLine();

                System.out.println("请输入第二个数字：");
                String b = input.nextLine();

                int a1 = Integer.parseInt(a);
                int b1 = Integer.parseInt(b);

                // OperatorFactory o = (OperatorFactory)Class.forName(ConfigUtil.getProjectConfig(test)).newInstance();

                Class<Object> oClass = (Class<Object>) forName(ConfigUtil.getProjectConfig(test));
                System.out.println(oClass);
                Object oO = oClass.getDeclaredConstructor().newInstance();
                Method method1 = oClass.getMethod("getOperator");
                System.out.println(method1);
                Class impl = method1.invoke(oO).getClass();
                //Method method1 = object.getClass().getMethod()

                Object implObject = impl.getDeclaredConstructor().newInstance();
                Method method =impl.getMethod("getResult", int.class,int.class);

                Integer result = (Integer) method.invoke(implObject,a1,b1);
                //Integer result = o.getOperator().getResult(a1, b1);
                System.out.println("得到的结果是：");
                System.out.println(result);
            }


        } catch (Exception ignored) {

        }

    }
}
