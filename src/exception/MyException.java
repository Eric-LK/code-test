package exception;

/**
 * 自定义异常
 *
 * @author: 刘兵
 * @date: 2020/6/8 16:22
 **/
public class MyException extends Exception{

    /**
     * RunTimeException是不需要显式的抛出
     *
     *
     * @param message 异常描述信息
     */
    public MyException(String message) {
        super(message);
    }
}
