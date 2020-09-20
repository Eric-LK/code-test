package exception;



/**
 * controller 测试类
 *
 * @author: 刘兵
 * @date: 2020/6/8 16:36
 **/
public class ControllerTest {

    public static void main(String[] args) throws MyException {
        MainClass.test(0);
        MainClass mainClass = new MainClass();
        mainClass.test01(0);
    }
}
