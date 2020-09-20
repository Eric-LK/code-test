package test;

import org.junit.Test;

/**
 * 字符串练习
 *
 * @author: 刘兵
 * @date: 2020/6/25 10:14
 **/
public class StringTest {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        // toCharArray
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("123");
        stringBuffer.append("456");
        stringBuffer.insert(3, "7");

        stringBuffer.reverse();

        System.out.println(stringBuffer);

        String str = "123qwe";

        System.out.println(str.indexOf(3));

        // 就是获取一个新的工厂,
        // obtainFreshBeanFactory()内部的执行顺序: ==> refreshBeanFactory() ==> loadBeanDefinitions(beanFactory)
        // obtainFreshBeanFactory()方法会将xml中的配置bean都加载到内存中,后续的finishBeanFactoryInitialization创建bean时会用到.

        // ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

        // Prepare the bean factory for use in this context.
        // 准备BeanFactory

        // prepareBeanFactory(beanFactory);


    }


    @Test
    public void testO() {
        String test = "aabbbbccaa";
        char[] chars = test.toCharArray();
        char a ;
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            a = chars[i];
            if( i > 1 && chars[i-1] == a ){
                continue;
            }

            int temp = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (a == chars[j]) {
                    temp++;
                }
                break;
            }
            result  += a + Integer.toString(temp);
        }
        System.out.println(result);
        //return result;
    }
}
