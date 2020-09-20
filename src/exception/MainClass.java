package exception;

/**
 * 测试主类
 *
 * @author: 刘兵
 * @date: 2020/6/8 16:24
 **/
public class MainClass {


    public static String test(Integer number) throws MyException {
        if (number == 0){
            throw new MyException("自定义异常");
        }else{
            System.out.println("123");
        }
        return "123";
    }

    public void test01(Integer number) throws MyException{
        if (number == 0){
            try {
                throw new MyException("自定义异常");
            } catch (MyException e) {
                throw e;
            }
        }else{
            System.out.println("123");
        }
    }

}
